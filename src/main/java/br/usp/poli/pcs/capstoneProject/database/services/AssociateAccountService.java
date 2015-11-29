package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUserBankAccount;
import br.usp.poli.pcs.capstoneProject.database.implementations.UserBankAccountDAO;
import java.util.Map;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;
public class AssociateAccountService extends DatabaseService {
	
	private IUserBankAccount dao;
	
	public AssociateAccountService() {
		super();
		dao = new UserBankAccountDAO();
	}
	
	public UserBankAccount call(Map<String, Object> accountInformation) {
		return dao.associateAccount(db.getConnection(), accountInformation);
	}

}
