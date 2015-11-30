package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.List;
import java.util.Map;
import org.sql2o.Sql2o;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;

public interface ITransferIntention {
	public TransferIntention createTransferIntention(Sql2o sql2o, Map<String, Object> transferDetails);
	public List<TransferIntention> getPendingUserTransferIntentionsAsRecipient(Sql2o sql2o, int userId);
	public List<TransferIntention> getPendingUserTransferIntentionsAsSender(Sql2o sql2o, int userId);
	public boolean rejectTransferIntention(Sql2o sql2o, int transferIntentionId, int userId);
	public boolean approveTransferIntention(Sql2o sql2o, int transferIntentionId, int userId);
	public boolean voidTransferIntention(Sql2o sql2o, int transferIntentionId, int userId);
}
