package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;

import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IBank;
import br.usp.poli.pcs.capstoneProject.models.Bank;

public class BankDAO implements IBank{

	public List<Bank> getBanks(Sql2o sql2o) {
		Connection connection = sql2o.beginTransaction();
		List<Bank> banks = connection.createQuery("SELECT * FROM banks")
								.executeAndFetch(Bank.class);
		connection.commit();
		return banks;
	}

	public Bank createBank(Sql2o sql2o, Map<String, Object> bankInformation) {
		Bank bank;
		try (Connection connection = sql2o.beginTransaction()) {
			int bankId = connection.createQuery("INSERT INTO banks(name) VALUES (:name)", true)
				.addParameter("name", bankInformation.get("name"))
				.executeUpdate()
				.getKey(Integer.class);
			bank = connection.createQuery("SELECT * FROM banks WHERE id = :id ")
				.addParameter("id", bankId)
				.executeAndFetchFirst(Bank.class);
			connection.commit();
		} 
		return bank;
	}

	@Override
	public boolean receiveWithdraw(Sql2o sql2o, int withdrawId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveDeposit(Sql2o sql2o, int depositId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Integer> getBankIds(Sql2o sql2o) {
		Connection connection = sql2o.beginTransaction();
		List<Integer> ids = connection.createQuery("SELECT id FROM banks").executeAndFetch(Integer.class);
		connection.commit();
		return ids;
	}
}
