package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.database.implementations.TransferIntentionDAO;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;

public class GetTransferIntentionByIdService extends DatabaseService {
	
	private ITransferIntention dao;
	
	public GetTransferIntentionByIdService() {
		super();
		dao = new TransferIntentionDAO();
	}
	
	public TransferIntention call(int transferId, int recipientId) {
		return dao.getTransferIntentionById(db.getConnection(), transferId, recipientId);
	}
	
}
