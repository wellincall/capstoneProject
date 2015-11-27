package br.usp.poli.pcs.capstoneProject.helpers;

import java.util.List;
import br.usp.poli.pcs.capstoneProject.databaseImplementation.BankDAO;
import br.usp.poli.pcs.capstoneProject.databaseInterface.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.models.Bank;


public class GetBanksService {
	private CapstoneConnection db;
	private BankDAO dao;
	
	public GetBanksService() {
		db = new CapstoneConnection();
		dao = new BankDAO();
	}
	public List<Bank> call() {
		return dao.getBanks(db.getConnection());
	}
}
