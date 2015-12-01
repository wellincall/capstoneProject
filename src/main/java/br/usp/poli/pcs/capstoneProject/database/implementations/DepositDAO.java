package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;

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
	public Deposit createDeposit(Connection connection, Map<String, Object> depositInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean consolidateDeposit(Connection connection, int transferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptDeposit(Connection connection, int transferIntentionId) {
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
