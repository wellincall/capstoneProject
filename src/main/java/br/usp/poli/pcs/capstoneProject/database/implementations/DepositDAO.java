package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;
import java.util.Date;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IDeposit;
import br.usp.poli.pcs.capstoneProject.models.Deposit;

public class DepositDAO implements IDeposit {

	@Override
	public List<Deposit> getUserDeposits(Sql2o sql2o, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deposit createDeposit(Sql2o sql2o, Map<String, Object> depositInformation) {
		Deposit deposit = null;
		try (Connection connection = sql2o.beginTransaction()) {
			int depositId = connection.createQuery("INSERT INTO deposits("
					+ "bankid, accounttoken, transferintentionid, value, status, creationdate"
					+ ") "
					+ "VALUES "
					+ "(:bankId, :accountToken, :transferId, :value, :status, :creationDate)", true)
					.addParameter("bankId", depositInformation.get("bank-id"))
					.addParameter("accountToken", depositInformation.get("account-token"))
					.addParameter("transferId", depositInformation.get("transfer-id"))
					.addParameter("value", depositInformation.get("amount"))
					.addParameter("status", Deposit.ACCEPTED)
					.addParameter("creationDate", new Date())
					.executeUpdate().getKey(Integer.class);
			deposit = connection.createQuery("SELECT * FROM deposits WHERE id = :id")
								.addParameter("id", depositId)
								.executeAndFetchFirst(Deposit.class);
		}
		return deposit;
	}

	@Override
	public boolean consolidateDeposit(Connection connection, int transferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean declineDeposit(Connection connection, int transferIntentionId) {
		boolean hasDeclinedDeposit = false;
		Deposit deposit = connection.createQuery("SELECT * FROM deposits WHERE transferintentionid = :transferId")
							.addParameter("transferId", transferIntentionId)
							.executeAndFetchFirst(Deposit.class);
		if (deposit != null) {
			if (deposit.canBeDeclined()) {
				connection.createQuery("UPDATE deposits SET status = :status WHERE id = :depositId AND transferintentionid = :transferId")
								.addParameter("depositId", deposit.getId())
								.addParameter("transferId", transferIntentionId)
								.addParameter("status", Deposit.DECLINED)
								.executeUpdate();
				hasDeclinedDeposit = true;
			}
		}
		
		return hasDeclinedDeposit;
	}

	@Override
	public boolean voidDeposit(Connection connection, int transferIntentionId) {
		boolean hasVoidedDeposit = false;
		Deposit deposit = connection.createQuery("SELECT * FROM deposits WHERE transferintentionid = :transferId")
							.addParameter("transferId", transferIntentionId)
							.executeAndFetchFirst(Deposit.class);
		if (deposit != null) {
			if (deposit.canBeVoided()) {
				connection.createQuery("UPDATE deposits SET status = :status WHERE id = :id AND transferintentionid = :transferId")
						.addParameter("status", Deposit.VOIDED)
						.addParameter("id", deposit.getId())
						.addParameter("transferId", transferIntentionId)
						.executeUpdate();
				hasVoidedDeposit = true;
			}
		}
		return hasVoidedDeposit;
	}

}
