package br.usp.poli.pcs.capstoneProject.database;

import java.util.List;
import java.util.Map;
import org.sql2o.Sql2o;
import br.usp.poli.pcs.capstoneProject.models.Deposit;

public interface IDeposit {
	public List<Deposit> getUserDeposits(Sql2o sql2o, int userId);
	public Deposit createDeposit(Sql2o sql2o, Map<String, Object> depositInformation);
	public boolean bankReceivedDeposit(Sql2o sql2o, int depositId);
}
