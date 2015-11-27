package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.List;
import java.util.Map;

import br.usp.poli.pcs.capstoneProject.models.Bank;
import org.sql2o.Sql2o;


public interface IBank {
	public List<Bank> getBanks(Sql2o sql2o);
	public Bank createBank(Sql2o sql2o, Map<String, Object> bankInformation);
	public boolean receiveWithdraw(Sql2o sql2o, int withdrawId);
	public boolean receiveDeposit(Sql2o sql2o, int depositId);
}
