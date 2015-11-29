package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;
import java.util.Date;

import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;


public class TransferIntentionDAO implements ITransferIntention {

	@Override
	public TransferIntention createTransferIntention(Sql2o sql2o, Map<String, Object> transferDetails) {
		try(Connection connection = sql2o.beginTransaction()) {
			int transferId = connection.createQuery("INSERT INTO transferintentions(value, recipientid, senderid, status, creationdate)"
					+ " VALUES (:value, :recipientId, :senderId, :status, :creationDate)", true)
					.addParameter("value", transferDetails.get("amount"))
					.addParameter("recipientId", transferDetails.get("recipient-id"))
					.addParameter("senderId", transferDetails.get("sender-id"))
					.addParameter("status", TransferIntention.CREATED)
					.addParameter("creationDate", new Date())
					.executeUpdate()
					.getKey(Integer.class);
			
			connection.commit();
		}
		return null;
	}

	@Override
	public List<TransferIntention> getUserTransferIntentions(Sql2o sql2o, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userVisualizedTransferIntention(Sql2o sql2o, int transferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userRejectedTransferIntention(Sql2o sql2o, int transferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userApprovedTransferIntention(Sql2o sql2o, int transferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userSuspendedTransferIntention(Sql2o sql2o, int trasnferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

}
