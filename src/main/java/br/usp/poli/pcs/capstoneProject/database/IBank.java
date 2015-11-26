package br.usp.poli.pcs.capstoneProject.database;

import java.util.List;
import java.util.Map;

import br.usp.poli.pcs.capstoneProject.models.Bank;
import org.sql2o.Sql2o;


public interface IBank {
	public List<Bank> getBanks(Sql2o sql2o);
	public Bank createBank(Sql2o sql2o, Map<String, Object> bankInformation);
	public boolean hasBankAccount(Sql2o sql2o, Map<String, Object> accountDetails);
	public String tokenFromAccount(Sql2o sql2o, Map<String, Object> accountDetails);
}
