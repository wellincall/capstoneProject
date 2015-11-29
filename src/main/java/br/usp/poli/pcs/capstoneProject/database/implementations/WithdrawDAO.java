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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bankReceivedWithdraw(Connection connection, int withdrawId) {
		// TODO Auto-generated method stub
		return false;
	}

}
