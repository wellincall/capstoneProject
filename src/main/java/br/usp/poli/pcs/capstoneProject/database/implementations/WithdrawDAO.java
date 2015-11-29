package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;

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
		int withdrawId = connection.createQuery("INSERT INTO withdraws(bankid, accounttoken, transferintentionid, value, status) VALUES "
				+ "(:bankId, :accountToken, :transferIntentionId, :value, :status)", true)
					.addParameter("bankId", withdrawInformation.get("bank-id"))
					.addParameter("accountToken", withdrawInformation.get("account-token"))
					.addParameter("tranferIntentionId", withdrawInformation.get("transfer-intention-id"))
					.addParameter("value", Double.valueOf(String.valueOf(withdrawInformation.get("value"))))
					.addParameter("status", Withdraw.CREATED)
					.executeUpdate().getKey(Integer.class);
		Withdraw withdraw = connection.createQuery("SELECT * FROM withdraws WHERE id = :id")
					.addParameter("id", withdrawId)
					.executeAndFetchFirst(Withdraw.class);
		return withdraw;
	}

	@Override
	public boolean bankReceivedWithdraw(Connection connection, int withdrawId) {
		// TODO Auto-generated method stub
		return false;
	}

}
