package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.Map;
import org.sql2o.Sql2o;
import br.usp.poli.pcs.capstoneProject.models.BankAccount;

public interface IBankAccount {
	public BankAccount createBankAccount(Sql2o sql2o, Map<String, Object> accountInformation);
	public boolean hasValidInformation(Sql2o sql2o, Map<String, Object> accountDetails);
	public String tokenFromAccount(Sql2o sql2o, Map<String, Object> accountDetails);
	public int getBankIdFromToken(Sql2o sql2o, String token);
}
