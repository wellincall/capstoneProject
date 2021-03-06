package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUserBankAccount;
import br.usp.poli.pcs.capstoneProject.database.implementations.UserBankAccountDAO;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;

public class GetUserBankAccountByIdService extends DatabaseService {

	private IUserBankAccount dao;
	
	public GetUserBankAccountByIdService() {
		super();
		dao = new UserBankAccountDAO();
	}
	
	public UserBankAccount call(int accountId, int userId) {
		return dao.getUserBankAccountById(db.getConnection(), accountId, userId);
	}
		
}
