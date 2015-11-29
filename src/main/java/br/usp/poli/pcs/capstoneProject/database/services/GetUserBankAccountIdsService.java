package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUserBankAccount;
import br.usp.poli.pcs.capstoneProject.database.implementations.UserBankAccountDAO;
import java.util.List;

public class GetUserBankAccountIdsService extends DatabaseService {
	
	private IUserBankAccount dao;
	
	public GetUserBankAccountIdsService() {
		super();
		dao = new UserBankAccountDAO();
	}
	
	public List<Integer> call(int userId) {
		return dao.getUserBankAccountsId(db.getConnection(), userId);
	}
}
