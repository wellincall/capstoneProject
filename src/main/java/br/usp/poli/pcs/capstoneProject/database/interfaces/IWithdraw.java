package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.Map;
import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.Withdraw;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

public interface IWithdraw {
	public Withdraw createWithdraw(Connection connection, Map<String, Object> withdrawInformation);
	public boolean consolidateWithdraw(Connection connection, int transferIntentionId);
	public boolean voidWithdraw(Connection connection, int transferIntentionId);
	public boolean acceptWithdraw(Connection connection, int transferIntentionId);
	public boolean declineWithdraw(Connection connection, int transferIntentionId);
}
