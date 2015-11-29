package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;

import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUserBankAccount;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;


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
