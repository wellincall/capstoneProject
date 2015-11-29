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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBankAccount associateAccount(Sql2o sql2o, Map<String, Object> associationInformation) {
		UserBankAccount userAccount = null;
		try(Connection connection = sql2o.beginTransaction()) {
			if ((new BankAccountValidatorService()).call(associationInformation)) {
				String token = (new GetTokenService()).call(associationInformation);
				int associationId = connection.createQuery("INSERT INTO useraccounts(userid, accounttoken) VALUES (:userId, :token)", true)
								.addParameter("userId" , Integer.valueOf(String.valueOf(associationInformation.get("user-id"))))
								.addParameter("token" , token)
								.executeUpdate().getKey(Integer.class);
				userAccount = connection.createQuery("SELECT * FROM useraccounts WHERE id = :id")
									.addParameter("id", associationId)
									.executeAndFetchFirst(UserBankAccount.class);
			}			
			connection.commit();
		}
		return userAccount;
	}

	@Override
	public boolean removeAccount(Sql2o sql2o, int userId, int userBankAccountId) {
		// TODO Auto-generated method stub
		return false;
	}

}
