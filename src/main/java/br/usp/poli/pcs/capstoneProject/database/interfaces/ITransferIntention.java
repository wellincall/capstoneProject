package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.List;
import java.util.Map;
import org.sql2o.Sql2o;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;

public interface ITransferIntention {
	public TransferIntention createTransferIntention(Sql2o sql2o, Map<String, Object> transferDetails);
	public TransferIntention getTransferIntentionById(Sql2o sql2o, int transferId, int recipientId);
	public List<TransferIntention> getPendingUserTransferIntentionsAsRecipient(Sql2o sql2o, int userId);
	public List<TransferIntention> getPendingUserTransferIntentionsAsSender(Sql2o sql2o, int userId);
	public boolean declineTransferIntention(Sql2o sql2o, int transferIntentionId, int userId);
	public boolean acceptTransferIntention(Sql2o sql2o, int transferIntentionId, int userId);
	public boolean voidTransferIntention(Sql2o sql2o, int transferIntentionId, int userId);
	public List<TransferIntention> getTransferIntentionsToBeConsolidated(Sql2o sql2o);
	public TransferIntention consolidateTransferIntention(Sql2o sql2o, int transferIntentionId);
}
