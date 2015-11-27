package br.usp.poli.pcs.capstoneProject.database.services;

import java.util.List;

import br.usp.poli.pcs.capstoneProject.database.implementations.BankDAO;
import br.usp.poli.pcs.capstoneProject.database.interfaces.CapstoneConnection;


public class GetBankIdsService {
	private CapstoneConnection db;
	private BankDAO dao;
	
	public GetBankIdsService() {
		db = new CapstoneConnection();
		dao = new BankDAO();
	}
	public List<Integer> call() {
		return dao.getBankIds(db.getConnection());
	}
}

