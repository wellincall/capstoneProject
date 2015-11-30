package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.database.implementations.TransferIntentionDAO;
import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;

public class GetTransferIntentionsForSenderService extends DatabaseService {
	
	private ITransferIntention dao;
	
	public GetTransferIntentionsForSenderService() {
		super();
		dao = new TransferIntentionDAO();
	}
	
	public List<TransferIntention> call(int userId) {
		return dao.getPendingUserTransferIntentionsAsSender(db.getConnection(), userId);
	}
}
