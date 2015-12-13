package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.database.interfaces.ITransferIntention;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;
import br.usp.poli.pcs.capstoneProject.database.services.GetBankIdFromTokenService;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;

public class TransferIntentionDAO implements ITransferIntention {

	@Override
	public TransferIntention createTransferIntention(Sql2o sql2o, Map<String, Object> transferDetails) {
		TransferIntention transfer = null;
		try(Connection connection = sql2o.beginTransaction()) {
			int senderId = Integer.valueOf(String.valueOf(transferDetails.get("sender-id")));
			int recipientId = Integer.valueOf(String.valueOf(transferDetails.get("recipient-id")));
			if (senderId != recipientId) {
				int transferId = connection.createQuery("INSERT INTO transferintentions(value, recipientid, senderid, status, creationdate)"
						+ " VALUES (:value, :recipientId, :senderId, :status, :creationDate)", true)
						.addParameter("value", Double.valueOf(String.valueOf(transferDetails.get("amount"))))
						.addParameter("recipientId", recipientId)
						.addParameter("senderId", transferDetails.get("sender-id"))
						.addParameter("status", TransferIntention.CREATED)
						.addParameter("creationDate", new Date())
						.executeUpdate()
						.getKey(Integer.class);
				Map<String, Object> withdrawDetails = new HashMap<String, Object>();
				int accountId = Integer.valueOf(String.valueOf(transferDetails.get("sender-account-id")));
				UserBankAccount senderAccount = (new UserBankAccountDAO()).getUserBankAccountById(connection, accountId, senderId);
				int bankId = (new GetBankIdFromTokenService()).call(senderAccount.getAccountToken());
				withdrawDetails.put("bank-id", bankId);
				withdrawDetails.put("account-token", senderAccount.getAccountToken());
				withdrawDetails.put("value", transferDetails.get("amount"));
				withdrawDetails.put("transfer-intention-id", transferId);
				if ((new WithdrawDAO()).createWithdraw(connection, withdrawDetails) != null) {
					transfer = connection.createQuery("SELECT * FROM transferintentions WHERE id = :id")
											.addParameter("id", transferId)
											.executeAndFetchFirst(TransferIntention.class);
					connection.commit();
				} else {
					connection.rollback();
				}
			} else {
				connection.commit();
			}
		}
		return transfer;
	}

	@Override
	public List<TransferIntention> getPendingUserTransferIntentionsAsRecipient(Sql2o sql2o, int userId) {
		List<TransferIntention> transferIntentions = null;
		try(Connection connection = sql2o.beginTransaction()) {
			transferIntentions = connection.createQuery("SELECT * FROM transferintentions WHERE recipientid = :userId ORDER BY id DESC")
									.addParameter("userId", userId)
									.executeAndFetch(TransferIntention.class);
			
			connection.commit();
		}
		return transferIntentions;
	}
	
	@Override
	public List<TransferIntention> getPendingUserTransferIntentionsAsSender(Sql2o sql2o, int userId) {
		List<TransferIntention> transferIntentions = null;
		try(Connection connection = sql2o.beginTransaction()) {
			transferIntentions = connection.createQuery("SELECT * FROM transferintentions WHERE senderId = :userId ORDER BY id DESC")
									.addParameter("userId", userId)
									.executeAndFetch(TransferIntention.class);
			
			connection.commit();
		}
		return transferIntentions;
	}

	@Override
	public boolean declineTransferIntention(Sql2o sql2o, int transferIntentionId, int userId) {
		boolean hasRejectedTransfer = false;
		try (Connection connection = sql2o.beginTransaction()) {
			TransferIntention transfer = connection.createQuery("SELECT * FROM transferintentions WHERE id = :transferId AND recipientid = :userId")
											.addParameter("transferId", transferIntentionId)
											.addParameter("userId", userId)
											.executeAndFetchFirst(TransferIntention.class);
			if (transfer != null) {
				if (transfer.canBeDeclined()) {
					connection.createQuery("UPDATE transferintentions SET status = :status WHERE id = :transferId AND recipientid = :userId")
							.addParameter("status", TransferIntention.DECLINED)
							.addParameter("transferId", transfer.getId())
							.addParameter("userId", userId)
							.executeUpdate();
					(new WithdrawDAO()).declineWithdraw(connection, transfer.getId());
					(new DepositDAO()).declineDeposit(connection, transfer.getId());
					hasRejectedTransfer = true;
				}
			}
			connection.commit();
		}
		return hasRejectedTransfer;
	}

	@Override
	public boolean acceptTransferIntention(Sql2o sql2o, int transferIntentionId, int userId) {
		boolean hasAcceptedTransfer = false;
		try(Connection connection = sql2o.beginTransaction()) {
			TransferIntention transfer = connection.createQuery("SELECT * FROM transferintentions WHERE id = :transferId AND recipientid = :userId")
									.addParameter("transferId", transferIntentionId)
									.addParameter("userId", userId)
									.executeAndFetchFirst(TransferIntention.class);
		
			if (transfer.canBeAccepted()) {
				connection.createQuery("UPDATE transferintentions SET status = :status WHERE id = :id")
					.addParameter("id", transfer.getId())
					.addParameter("status", TransferIntention.ACCEPTED)
					.executeUpdate();
				if (!(new WithdrawDAO()).acceptWithdraw(connection, transferIntentionId)) {
					connection.rollback();
				} else {
					connection.commit();
					hasAcceptedTransfer = true;
				}
				
			} else {
				connection.commit();
			}
			
		}
		return hasAcceptedTransfer;
	}


	@Override
	public boolean voidTransferIntention(Sql2o sql2o, int transferIntentionId, int userId) {
		boolean hasVoidedTransfer = false;
		try(Connection connection = sql2o.beginTransaction()){
			Calendar dateLimit = Calendar.getInstance();
			dateLimit.add(Calendar.HOUR_OF_DAY, -8);
			TransferIntention transfer = connection.createQuery("SELECT * FROM transferintentions WHERE "
					+ "id = :transferId AND senderId = :senderId AND creationDate >= :dateLimit")
						.addParameter("transferId", transferIntentionId)
						.addParameter("senderId", userId)
						.addParameter("dateLimit", dateLimit.getTime())
						.executeAndFetchFirst(TransferIntention.class);
			if (transfer != null) {
				if (transfer.canBeVoided()) {
					connection.createQuery("UPDATE transferintentions SET status = :status WHERE id = :id")
						.addParameter("id", transfer.getId())
						.addParameter("status", TransferIntention.VOIDED)
						.executeUpdate();
					(new WithdrawDAO()).voidWithdraw(connection, transfer.getId());
					(new DepositDAO()).voidDeposit(connection, transfer.getId());
					hasVoidedTransfer = true;
				}
			}
			connection.commit();
		}
		return hasVoidedTransfer;
	}
	
	@Override
	public TransferIntention getTransferIntentionById(Sql2o sql2o, int transferId, int recipientId) {
		TransferIntention transfer = null;
		try (Connection connection = sql2o.beginTransaction()) {
			transfer = connection.createQuery("SELECT * FROM transferintentions WHERE id = :transferId AND recipientid = :recipientId")
								.addParameter("transferId", transferId)
								.addParameter("recipientId", recipientId)
								.executeAndFetchFirst(TransferIntention.class);
			connection.commit();
		}
		return transfer;
	}

	@Override
	public List<TransferIntention> getTransferIntentionsToBeConsolidated(Sql2o sql2o) {
		List<TransferIntention> transfersToConsolidate = null;
		try (Connection connection = sql2o.beginTransaction()) {
			Calendar dateLimit = Calendar.getInstance();
			dateLimit.add(Calendar.HOUR_OF_DAY, -8);
			transfersToConsolidate = connection.createQuery("SELECT * FROM transferintentions WHERE status = :status AND creationdate <= :limitToConsolidate")
									.addParameter("status", TransferIntention.ACCEPTED)
									.addParameter("limitToConsolidate", dateLimit.getTime())
									.executeAndFetch(TransferIntention.class);
			
			connection.commit();
		}
		return transfersToConsolidate;
	}

	@Override
	public TransferIntention consolidateTransferIntention(Sql2o sql2o, int transferIntentionId) {
		TransferIntention transfer = null;
		try (Connection connection = sql2o.beginTransaction()) {
			boolean shouldPerformRollback = false;
			transfer = connection.createQuery("SELECT * FROM transferintentions WHERE id = :transferId")
							.addParameter("transferId", transferIntentionId)
							.executeAndFetchFirst(TransferIntention.class);
			if (transfer != null && transfer.canBeConsolidated()) {
				
				connection.createQuery("UPDATE transferintentions SET status = :status WHERE id = :transferId")
							.addParameter("transferId", transferIntentionId)
							.addParameter("status", TransferIntention.CONSOLIDATED)
							.executeUpdate();
				shouldPerformRollback = (new WithdrawDAO()).consolidateWithdraw(connection, transferIntentionId) ? false : true;
				shouldPerformRollback = (new DepositDAO()).consolidateDeposit(connection, transferIntentionId) ? false : true;
				
			}
			if (shouldPerformRollback) {
				connection.rollback();
			} else {
				connection.commit();
			}
		}
		return transfer;
	}

	

}
