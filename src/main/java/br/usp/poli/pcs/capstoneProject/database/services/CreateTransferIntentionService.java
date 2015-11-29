package br.usp.poli.pcs.capstoneProject.database.services;

import java.util.Map;
import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.database.implementations.TransferIntentionDAO;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;

public class CreateTransferIntentionService extends DatabaseService {
	
	private ITransferIntention dao;
	
	public CreateTransferIntentionService() {
		super();
		dao = new TransferIntentionDAO();
	}
	
	public TransferIntention call(Map<String,Object> transferDetails) {
		return dao.createTransferIntention(db.getConnection(), transferDetails);
	}
}
