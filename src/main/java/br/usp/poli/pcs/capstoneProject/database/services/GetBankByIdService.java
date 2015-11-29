package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IBank;
import br.usp.poli.pcs.capstoneProject.database.implementations.BankDAO;
import br.usp.poli.pcs.capstoneProject.models.Bank;

public class GetBankByIdService extends DatabaseService {
	
	private IBank dao;
	
	public GetBankByIdService() {
		super();
		dao = new BankDAO();
	}
	
	public Bank call(int bankId) {
		return dao.getBankById(db.getConnection(), bankId);
	}
}
