package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUserBankAccount;
import br.usp.poli.pcs.capstoneProject.database.implementations.UserBankAccountDAO;

public class RemoveUserAccountService extends DatabaseService {
	
	private IUserBankAccount dao;
	
	public RemoveUserAccountService() {
		super();
		dao = new UserBankAccountDAO();
	}
	
	public boolean call(int userId, int userAccountId) {
		return dao.removeAccount(db.getConnection(), userId, userAccountId);
	}
	
	
}
