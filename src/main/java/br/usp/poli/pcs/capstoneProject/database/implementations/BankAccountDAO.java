package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.Map;

import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.models.BankAccount;
import br.usp.poli.pcs.capstoneProject.database.interfaces.IBankAccount;
import br.usp.poli.pcs.capstoneProject.helpers.TokenGenerator;

public class BankAccountDAO implements IBankAccount {

	public BankAccount createBankAccount(Sql2o sql2o, Map<String, Object> accountInformation) {
		BankAccount account = null;
		try (Connection connection = sql2o.beginTransaction()) {
			if (canRegisterAccount(connection, accountInformation)) {
				String token = TokenGenerator.call(accountInformation);
				int accountId = connection.createQuery("INSERT INTO bankAccounts(bankId, accountNumber, "
						+ "agencyNumber, accountOwnerName, accountOwnerCPF, accountOwnerBirthdayDate, "
						+ "token) VALUES (:bankId, :accountNumber, "
						+ ":agencyNumber, :accountOwnerName, :accountOwnerCPF, :accountOwnerBirthdayDate, "
						+ ":token)", true)
					.addParameter("bankId", accountInformation.get("bank-id"))
					.addParameter("accountNumber", accountInformation.get("account-number"))
					.addParameter("agencyNumber", accountInformation.get("agency-number"))
					.addParameter("accountOwnerName", accountInformation.get("account-owner-name"))
					.addParameter("accountOwnerCPF", accountInformation.get("account-owner-cpf"))
					.addParameter("accountOwnerBirthdayDate", accountInformation.get("account-owner-birthday-date"))
					.addParameter("token", token)
					.executeUpdate()
					.getKey(Integer.class);
				account = connection.createQuery("SELECT * FROM bankAccounts WHERE id = :id")
							.addParameter("id", accountId)
							.executeAndFetchFirst(BankAccount.class);
			}
			connection.commit();
		}
		return account;
	}

	@Override
	public boolean deleteBankAccount(Sql2o sql2o, int bankAccountId, int bankId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasValidInformation(Sql2o sql2o, Map<String, Object> accountDetails) {
		BankAccount bankAccount = null;
		try(Connection connection = sql2o.beginTransaction()) {
			bankAccount = connection.createQuery("SELECT * FROM bankaccounts WHERE "
					+ "accountownercpf = :cpf AND accountownername = :name "
					+ "AND accountownerbirthdaydate = :birthdayDate AND "
					+ "accountnumber = :accountNumber AND agencynumber = :agencyNumber "
					+ "AND bankid = :bankId")
					.addParameter("name" , accountDetails.get("name"))
					.addParameter("cpf" , accountDetails.get("cpf"))
					.addParameter("birthdayDate" , accountDetails.get("birthday-date"))
					.addParameter("accountNumber" , accountDetails.get("account-number"))
					.addParameter("agencyNumber" , accountDetails.get("agency-number"))
					.addParameter("bankId" , Integer.valueOf(String.valueOf(accountDetails.get("bank-id"))))
					.executeAndFetchFirst(BankAccount.class);
			connection.commit();
		}
		return bankAccount != null;
	}

	@Override
	public String tokenFromAccount(Sql2o sql2o, Map<String, Object> accountDetails) {
		StringBuffer token = new StringBuffer();
		try(Connection connection = sql2o.beginTransaction()) {
			token.append(connection.createQuery("SELECT token FROM bankaccounts WHERE "
					+ "accountownercpf = :cpf AND accountownername = :name "
					+ "AND accountownerbirthdaydate = :birthdayDate AND "
					+ "accountnumber = :accountNumber AND agencynumber = :agencyNumber "
					+ "AND bankid = :bankId")
					.addParameter("name" , accountDetails.get("name"))
					.addParameter("cpf" , accountDetails.get("cpf"))
					.addParameter("birthdayDate" , accountDetails.get("birthday-date"))
					.addParameter("accountNumber" , accountDetails.get("account-number"))
					.addParameter("agencyNumber" , accountDetails.get("agency-number"))
					.addParameter("bankId" , Integer.valueOf(String.valueOf(accountDetails.get("bank-id"))))
					.executeAndFetchFirst(String.class));
			connection.commit();
		}
		return token.toString();
	}
	
	private boolean canRegisterAccount(Connection connection, Map<String, Object> accountInformation) {
		int registeredAccounts = connection.createQuery("SELECT count(id) FROM bankaccounts "
				+ "WHERE bankId = :bankId AND accountNumber = :accountNumber AND"
				+ " agencyNumber = :agencyNumber")
				.addParameter("bankId", accountInformation.get("bank-id"))
				.addParameter("accountNumber", accountInformation.get("account-number"))
				.addParameter("agencyNumber", accountInformation.get("agency-number"))
				.executeScalar(Integer.class);
		return registeredAccounts == 0;
	}
	
}
