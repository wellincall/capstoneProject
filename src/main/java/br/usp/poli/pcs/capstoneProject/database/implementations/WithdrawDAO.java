package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.Map;
import java.util.Date;

import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IWithdraw;
import br.usp.poli.pcs.capstoneProject.models.Withdraw;

public class WithdrawDAO implements IWithdraw {


	@Override
	public Withdraw createWithdraw(Connection connection, Map<String, Object> withdrawInformation) {
		int withdrawId = connection.createQuery("INSERT INTO withdraws(bankid, accounttoken, transferintentionid, value, status, creationdate) VALUES "
				+ "(:bankId, :accountToken, :transferIntentionId, :value, :status, :creationDate)", true)
					.addParameter("bankId", withdrawInformation.get("bank-id"))
					.addParameter("accountToken", withdrawInformation.get("account-token"))
					.addParameter("transferIntentionId", withdrawInformation.get("transfer-intention-id"))
					.addParameter("value", Double.valueOf(String.valueOf(withdrawInformation.get("value"))))
					.addParameter("status", Withdraw.CREATED)
					.addParameter("creationDate", new Date())
					.executeUpdate().getKey(Integer.class);
		Withdraw withdraw = connection.createQuery("SELECT * FROM withdraws WHERE id = :id")
					.addParameter("id", withdrawId)
					.executeAndFetchFirst(Withdraw.class);
		return withdraw;
	}

	@Override
	public boolean consolidateWithdraw(Connection connection, int transferIntentionId) {
		Withdraw withdraw = connection.createQuery("SELECT * FROM withdraws WHERE transferintentionid = :transferId")
								.addParameter("transferId", transferIntentionId)
								.executeAndFetchFirst(Withdraw.class);
		
		if (withdraw.canBeConsolidated()) {
			connection.createQuery("UPDATE withdraws SET status = :status WHERE id = :withdrawId")
					.addParameter("status", Withdraw.CONSOLIDATED)
					.addParameter("withdrawId", withdraw.getId())
					.executeUpdate();
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean voidWithdraw(Connection connection, int transferIntentionId) {
		boolean hasVoidedWithdraw = false;
		Withdraw withdraw = connection.createQuery("SELECT * FROM withdraws WHERE transferintentionid = :transferId")
								.addParameter("transferId", transferIntentionId)
								.executeAndFetchFirst(Withdraw.class);
		if (withdraw != null) {
			if (withdraw.canBeVoided()) {
				connection.createQuery("UPDATE withdraws SET status = :status WHERE id = :id AND transferintentionid = :transferId")
							.addParameter("id", withdraw.getId())
							.addParameter("status", Withdraw.VOIDED)
							.addParameter("transferId", transferIntentionId)
							.executeUpdate();
				hasVoidedWithdraw = true;
			}
		}
		return hasVoidedWithdraw;
	}

	@Override
	public boolean acceptWithdraw(Connection connection, int transferIntentionId) {
		boolean hasAcceptedWithdraw = false;
		Withdraw withdraw = connection.createQuery("SELECT * FROM withdraws WHERE transferintentionid = :transferId")
								.addParameter("transferId", transferIntentionId)
								.executeAndFetchFirst(Withdraw.class);
		if (withdraw != null) {
			if (withdraw.canBeVoided()) {
				connection.createQuery("UPDATE withdraws SET status = :status WHERE id = :id AND transferintentionid = :transferId")
							.addParameter("id", withdraw.getId())
							.addParameter("status", Withdraw.ACCEPTED)
							.addParameter("transferId", transferIntentionId)
							.executeUpdate();
				hasAcceptedWithdraw = true;
			}
		}
		return hasAcceptedWithdraw;
	}

	@Override
	public boolean declineWithdraw(Connection connection, int transferIntentionId) {
		boolean hasDeclinedWithdraw = false;
		Withdraw withdraw = connection.createQuery("SELECT * FROM withdraws WHERE transferintentionid = :transferId")
								.addParameter("transferId",transferIntentionId)
								.executeAndFetchFirst(Withdraw.class);
		if (withdraw != null) {
			if (withdraw.canBeDeclined()) {
				connection.createQuery("UPDATE withdraws SET status = :status WHERE transferintentionid = :transferId")
							.addParameter("status", Withdraw.DECLINED)
							.addParameter("transferId", transferIntentionId)
							.executeUpdate();
				hasDeclinedWithdraw = true;
			}
		}
		return hasDeclinedWithdraw;
	}

}
