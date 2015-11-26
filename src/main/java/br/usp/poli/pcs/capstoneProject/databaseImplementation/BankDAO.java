package br.usp.poli.pcs.capstoneProject.databaseImplementation;

import java.util.List;
import java.util.Map;

import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.databaseInterface.IBank;
import br.usp.poli.pcs.capstoneProject.models.Bank;

public class BankDAO implements IBank{

	@Override
	public List<Bank> getBanks(Sql2o sql2o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bank createBank(Sql2o sql2o, Map<String, Object> bankInformation) {
		Bank bank;
		try (Connection connection = sql2o.beginTransaction()) {
			int bankId = connection.createQuery("INSERT INTO banks(name) VALUES (:name)")
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

}
