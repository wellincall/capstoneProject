package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.database.implementations.TransferIntentionDAO;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;
import java.util.List;

public class ConsolidateTransfersService extends DatabaseService {

	private ITransferIntention dao;
		
	public ConsolidateTransfersService() {
		super();
		dao = new TransferIntentionDAO();
	}
	
	public void call() {
		List<TransferIntention> transfersToBeConsolidated = dao.getTransferIntentionsToBeConsolidated(db.getConnection());
		for (TransferIntention transfer : transfersToBeConsolidated) {
			dao.consolidateTransferIntention(db.getConnection(), transfer.getId());
		}
	}
		
}
