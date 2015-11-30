package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.database.implementations.TransferIntentionDAO;

public class VoidTransferIntentionService extends DatabaseService {

	private ITransferIntention dao;
	
	public VoidTransferIntentionService() {
		super();
		dao = new TransferIntentionDAO();
	}
	
	public boolean call(int transferIntentionId, int userId) {
		return dao.voidTransferIntention(db.getConnection(), transferIntentionId, userId);
	}
	
	
}
