package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.List;
import java.util.Map;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import br.usp.poli.pcs.capstoneProject.models.Deposit;

public interface IDeposit {
	public List<Deposit> getUserDeposits(Sql2o sql2o, int userId);
	public Deposit createDeposit(Connection connection, Map<String, Object> depositInformation);
	public boolean bankReceivedDeposit(Connection connection, int depositId);
}
