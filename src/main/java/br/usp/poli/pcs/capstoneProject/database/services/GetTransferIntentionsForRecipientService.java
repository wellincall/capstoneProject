package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.models.TransferIntention;
import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.database.implementations.TransferIntentionDAO;
import java.util.List;

public class GetTransferIntentionsForRecipientService extends DatabaseService {
	
	private ITransferIntention dao;
	
	public GetTransferIntentionsForRecipientService() {
		super();
		dao = new TransferIntentionDAO();
	}
	
	public List<TransferIntention> call(int userId) {
		return dao.getPendingUserTransferIntentionsAsRecipient(db.getConnection(), userId);
	}
	
}
