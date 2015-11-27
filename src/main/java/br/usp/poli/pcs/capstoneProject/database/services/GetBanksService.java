package br.usp.poli.pcs.capstoneProject.database.services;

import java.util.List;

import br.usp.poli.pcs.capstoneProject.database.implementations.BankDAO;
import br.usp.poli.pcs.capstoneProject.database.interfaces.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.models.Bank;


public class GetBanksService extends DatabaseService {
	private BankDAO dao;
	
	public GetBanksService() {
		super();
		dao = new BankDAO();
	}
	public List<Bank> call() {
		return dao.getBanks(db.getConnection());
	}
}
