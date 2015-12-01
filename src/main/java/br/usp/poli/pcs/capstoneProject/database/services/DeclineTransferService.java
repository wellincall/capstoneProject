package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.database.implementations.TransferIntentionDAO;


public class DeclineTransferService extends DatabaseService {

	private ITransferIntention dao;
	
	public DeclineTransferService() {
		super();
		dao = new TransferIntentionDAO();
	}
	
	public boolean call(int transferIntentionId, int userId) {
		return dao.declineTransferIntention(db.getConnection(), transferIntentionId, userId);
	}
	
}
