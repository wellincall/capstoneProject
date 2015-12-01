package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.List;
import java.util.Map;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

public interface IUserBankAccount {
	public List<UserBankAccount> getUserAccounts(Sql2o sql2o, int userId);
	public UserBankAccount associateAccount(Sql2o sql2o, Map<String, Object> associationInformation);
	public boolean removeAccount(Sql2o sql2o, int userId, int userBankAccountId);
	public List<Integer> getUserBankAccountsId(Sql2o sql2o, int userId);
	public UserBankAccount getUserBankAccountById(Connection connection, int userBankAccountId, int userId);
	public UserBankAccount getUserBankAccountById(Sql2o sql2o, int userBankAccountId, int userId);

}
