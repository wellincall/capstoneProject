package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.List;
import java.util.Map;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import br.usp.poli.pcs.capstoneProject.models.Deposit;

public interface IDeposit {
	public Deposit createDeposit(Sql2o sql2o, Map<String, Object> depositInformation);
	public boolean consolidateDeposit(Connection connection, int transferIntentionId);
	public boolean declineDeposit(Connection connection, int transferIntentionId);
	public boolean voidDeposit(Connection connection, int transferIntentionId);
}
