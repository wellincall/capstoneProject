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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean voidDeposit(Connection connection, int transferIntentionId) {
		// TODO Auto-generated method stub
		return false;
	}

}
