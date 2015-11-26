package br.usp.poli.pcs.capstoneProject.databaseInterface;

import java.util.Map;
import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.Withdraw;
import org.sql2o.Sql2o;

public interface IWithdraw {
	public List<Withdraw> getUserWithdraws(Sql2o sql2o, int userId);
	public Withdraw createWithdraw(Sql2o sql2o, Map<String, Object> withdrawInformation);
	public boolean bankReceivedWithdraw(Sql2o sql2, int withdrawId);
}
