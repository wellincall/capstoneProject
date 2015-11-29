package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;

import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUserBankAccount;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;
import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.database.services.GetTokenService;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserByIdService;
import br.usp.poli.pcs.capstoneProject.database.services.BankAccountValidatorService;

public class UserBankAccountDAO implements IUserBankAccount{

	@Override
	public List<UserBankAccount> getUserAccounts(Sql2o sql2o, int userId) {
		List<UserBankAccount> userBankAccounts = null;
		try(Connection connection = sql2o.beginTransaction()) {
			userBankAccounts = connection.createQuery("SELECT * FROM userbankaccounts WHERE userid = :userId")
						.addParameter("userId", userId)
						.executeAndFetch(UserBankAccount.class);
			connection.commit();
		}
		return userBankAccounts;
	}

	@Override
	public UserBankAccount associateAccount(Sql2o sql2o, Map<String, Object> associationInformation) {
		UserBankAccount userAccount = null;
		try(Connection connection = sql2o.beginTransaction()) {
			if ((new BankAccountValidatorService()).call(associationInformation)) {
				String token = (new GetTokenService()).call(associationInformation);
				if (canCreateAssociation(connection, token, associationInformation)) {
					int associationId = connection.createQuery("INSERT INTO userbankaccounts(userid, accounttoken) VALUES (:userId, :token)", true)
									.addParameter("userId" , associationInformation.get("user-id"))
									.addParameter("token" , token)
									.executeUpdate().getKey(Integer.class);
					userAccount = connection.createQuery("SELECT * FROM userbankaccounts WHERE id = :id")
										.addParameter("id", associationId)
										.executeAndFetchFirst(UserBankAccount.class);
				}
			}			
			connection.commit();
		}
		return userAccount;
	}

	@Override
	public boolean removeAccount(Sql2o sql2o, int userId, int userBankAccountId) {
		boolean removedAccount = false;
		try (Connection connection = sql2o.beginTransaction()) {
			if (userHasAccount(connection, userId, userBankAccountId)) {
				connection.createQuery("DELETE FROM userbankaccounts WHERE id = :userBankAccountId AND userid = :userId ")
					.addParameter("userBankAccountId", userBankAccountId)
					.addParameter("userId", userId)
					.executeUpdate();
				removedAccount = true;
			}
			
			connection.commit();
		}
		return removedAccount;
	}
	
	
	private boolean userHasAccount(Connection connection, int userId, int userBankAccountId) {
		int registeredAccounts = connection.createQuery("SELECT count(id) FROM userbankaccounts WHERE userid = :userId AND id = :userBankAccountId")
					.addParameter("userId", userId)
					.addParameter("userBankAccountId", userBankAccountId)
					.executeScalar(Integer.class);
		
		return registeredAccounts == 1;
	}
	
	private boolean canCreateAssociation(Connection connection, String token, Map<String, Object> accountInformation) {
		int existingAccounts = connection.createQuery("SELECT count(id) FROM userbankaccounts WHERE accounttoken = :token AND userid = :userId")
				.addParameter("userId" , accountInformation.get("user-id"))
				.addParameter("token" , token)
				.executeScalar(Integer.class);
		return existingAccounts == 0;
		
	}

	@Override
	public List<Integer> getUserBankAccountsId(Sql2o sql2o, int userId) {
		List<Integer> accountsIds = null;
		Connection connection = sql2o.beginTransaction();
		accountsIds = connection.createQuery("SELECT id FROM userbankaccounts WHERE userid = :userId")
						.addParameter("userId", userId)
						.executeAndFetch(Integer.class);
		connection.commit();
		return accountsIds;
	}

	@Override
	public UserBankAccount getUserBankAccountById(Connection connection, int userBankAccountId, int userId) {
		UserBankAccount account = connection.createQuery("SELECT * FROM userbankaccounts WHERE id = :id AND userid = :userId")
					.addParameter("id", userBankAccountId)
					.addParameter("userId", userId)
					.executeAndFetchFirst(UserBankAccount.class);
		return account;
	}
}
