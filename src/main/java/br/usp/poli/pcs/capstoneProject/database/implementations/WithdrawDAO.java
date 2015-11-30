package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;
import java.util.Date;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IWithdraw;
import br.usp.poli.pcs.capstoneProject.models.Withdraw;

public class WithdrawDAO implements IWithdraw {

	@Override
	public List<Withdraw> getUserWithdraws(Sql2o sql2o, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

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
	public boolean consolidateWithdraw(Connection connection, int withdrawId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean voidWithdraw(Connection connection, int transferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptWithdraw(Connection connection, int transferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectWithdraw(Connection connection, int transferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

}
