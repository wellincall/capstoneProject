package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.Map;

import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.models.BankAccount;
import br.usp.poli.pcs.capstoneProject.database.interfaces.IBankAccount;
import br.usp.poli.pcs.capstoneProject.security.TokenGeneratorService;

public class BankAccountDAO implements IBankAccount {

	public BankAccount createBankAccount(Sql2o sql2o, Map<String, Object> accountInformation) {
		BankAccount account = null;
		try (Connection connection = sql2o.beginTransaction()) {
			if (canRegisterAccount(connection, accountInformation)) {
				String token = (new TokenGeneratorService()).call();
				int accountId = connection.createQuery("INSERT INTO bankAccounts(bankId, accountNumber, "
						+ "agencyNumber, accountOwnerName, accountOwnerCPF, accountOwnerBirthdayDate, "
						+ "accountOwnerPhoneNumber, token) VALUES (:bankId, :accountNumber, "
						+ ":agencyNumber, :accountOwnerName, :accountOwnerCPF, :accountOwnerBirthdayDate, "
						+ ":accountOwnerPhoneNumber, :token)", true)
					.addParameter("bankId", accountInformation.get("bank-id"))
					.addParameter("accountNumber", accountInformation.get("account-number"))
					.addParameter("agencyNumber", accountInformation.get("agency-number"))
					.addParameter("accountOwnerName", accountInformation.get("account-owner-name"))
					.addParameter("accountOwnerCPF", accountInformation.get("account-owner-cpf"))
					.addParameter("accountOwnerBirthdayDate", accountInformation.get("account-owner-birthday-date"))
					.addParameter("accountOwnerPhoneNumber", accountInformation.get("account-owner-phone-number"))
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
	public boolean hasValidInformation(Sql2o sql2o, Map<String, Object> accountDetails) {
		BankAccount bankAccount = null;
		try(Connection connection = sql2o.beginTransaction()) {
			bankAccount = connection.createQuery("SELECT * FROM bankaccounts WHERE "
					+ "accountownercpf = :cpf AND accountOwnerPhoneNumber = :phoneNumber "
					+ "AND accountownerbirthdaydate = :birthdayDate AND "
					+ "accountnumber = :accountNumber AND agencynumber = :agencyNumber "
					+ "AND bankid = :bankId")
					.addParameter("phoneNumber" , accountDetails.get("phone-number"))
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
					+ "accountownercpf = :cpf AND accountownerphonenumber = :phoneNumber "
					+ "AND accountownerbirthdaydate = :birthdayDate AND "
					+ "accountnumber = :accountNumber AND agencynumber = :agencyNumber "
					+ "AND bankid = :bankId")
					.addParameter("phoneNumber" , accountDetails.get("phone-number"))
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

	@Override
	public int getBankIdFromToken(Sql2o sql2o, String token) {
		int bankId = -1;
		try(Connection connection = sql2o.beginTransaction()) {
			bankId = connection.createQuery("SELECT bankid FROM bankaccounts WHERE token = :token")
						.addParameter("token", token)
						.executeScalar(Integer.class);
		}
		return bankId;
	}
	
}
