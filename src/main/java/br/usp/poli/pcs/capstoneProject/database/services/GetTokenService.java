package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IBankAccount;
import br.usp.poli.pcs.capstoneProject.database.implementations.BankAccountDAO;
import java.util.Map;

public class GetTokenService extends DatabaseService{
	
	private IBankAccount dao;
	
	public GetTokenService() {
		super();
		dao = new BankAccountDAO();
	}
	
	public String call(Map<String, Object> accountInformation) {
		return dao.tokenFromAccount(db.getConnection(), accountInformation);
	}
}
