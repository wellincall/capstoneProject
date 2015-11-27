package br.usp.poli.pcs.capstoneProject.database.services;

import java.util.List;

import br.usp.poli.pcs.capstoneProject.database.implementations.BankDAO;


public class GetBankIdsService extends DatabaseService{
	private BankDAO dao;
	
	public GetBankIdsService() {
		super();
		dao = new BankDAO();
	}
	public List<Integer> call() {
		return dao.getBankIds(db.getConnection());
	}
}

