package br.usp.poli.pcs.capstoneProject.database.services;

import java.util.Map;
import br.usp.poli.pcs.capstoneProject.database.interfaces.IDeposit;
import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.database.implementations.DepositDAO;
import br.usp.poli.pcs.capstoneProject.database.implementations.TransferIntentionDAO;

import br.usp.poli.pcs.capstoneProject.models.Deposit;

public class AcceptTransferService extends DatabaseService {
	
	private IDeposit depositDao;
	private ITransferIntention transferDao;
	
	public AcceptTransferService() {
		super();
		depositDao = new DepositDAO();
		transferDao = new TransferIntentionDAO();
	}
	
	public boolean call(Map<String, Object> acceptanceInfo) {
		boolean acceptedTransfer = false;
		int transferIntentionId = Integer.valueOf(String.valueOf(acceptanceInfo.get("transferId")));
		int userId = Integer.valueOf(String.valueOf(acceptanceInfo.get("userId")));
		acceptedTransfer = transferDao.acceptTransferIntention(db.getConnection(), transferIntentionId, userId);
		Deposit deposit = depositDao.createDeposit(db.getConnection(), acceptanceInfo);
		return acceptedTransfer && deposit != null;
	}
	
}
