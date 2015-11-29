package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IBankAccount;
import br.usp.poli.pcs.capstoneProject.database.implementations.BankAccountDAO;

public class GetBankIdFromTokenService extends DatabaseService {
	private IBankAccount dao;
	
	public GetBankIdFromTokenService() {
		super();
		dao = new BankAccountDAO();
	}
	
	public int call(String token) {
		return dao.getBankIdFromToken(db.getConnection(), token);
	}
}
