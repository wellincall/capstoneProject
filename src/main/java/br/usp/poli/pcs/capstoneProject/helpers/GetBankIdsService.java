package br.usp.poli.pcs.capstoneProject.helpers;

import java.util.List;
import br.usp.poli.pcs.capstoneProject.databaseImplementation.BankDAO;
import br.usp.poli.pcs.capstoneProject.databaseInterface.CapstoneConnection;


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

