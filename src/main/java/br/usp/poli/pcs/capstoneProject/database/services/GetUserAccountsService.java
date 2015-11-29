package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUserBankAccount;
import br.usp.poli.pcs.capstoneProject.database.implementations.UserBankAccountDAO;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;
import java.util.List;


public class GetUserAccountsService extends DatabaseService{

	private IUserBankAccount dao;
	
	public GetUserAccountsService() {
		super();
		dao = new UserBankAccountDAO();
	}
	
	public List<UserBankAccount> call(int userId) {
		return dao.getUserAccounts(db.getConnection(), userId);
	}
	
}
