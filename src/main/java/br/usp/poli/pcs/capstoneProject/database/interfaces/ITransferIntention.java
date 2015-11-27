package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.List;
import java.util.Map;
import org.sql2o.Sql2o;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;

public interface ITransferIntention {
	public TransferIntention createTransferIntention(Sql2o sql2o, Map<String, Object> transferDetails);
	public List<TransferIntention> getUserTransferIntentions(Sql2o sql2o, int userId);
	public boolean userVisualizedTransferIntention(Sql2o sql2o, int transferIntentionId);
	public boolean userRejectedTransferIntention(Sql2o sql2o, int transferIntentionId);
	public boolean userApprovedTransferIntention(Sql2o sql2o, int transferIntentionId);
	public boolean userSuspendedTransferIntention(Sql2o sql2o, int trasnferIntentionId);
}
