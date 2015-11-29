package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.Map;
import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.Withdraw;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

public interface IWithdraw {
	public List<Withdraw> getUserWithdraws(Sql2o sql2o, int userId);
	public Withdraw createWithdraw(Connection connection, Map<String, Object> withdrawInformation);
	public boolean bankReceivedWithdraw(Connection connection, int withdrawId);
}
