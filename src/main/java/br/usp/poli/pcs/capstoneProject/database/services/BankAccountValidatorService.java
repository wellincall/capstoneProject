package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IBankAccount;
import br.usp.poli.pcs.capstoneProject.database.implementations.BankAccountDAO;

import java.util.Map;

public class BankAccountValidatorService extends DatabaseService{
	
	private IBankAccount dao;
	public BankAccountValidatorService () {
		super();
		dao = new BankAccountDAO();
	}
	
	public boolean call(Map<String, Object> accountDetails) {
		return dao.hasValidInformation(db.getConnection(), accountDetails);
	}
	
}
