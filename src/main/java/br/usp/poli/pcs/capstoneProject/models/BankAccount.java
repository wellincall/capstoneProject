package br.usp.poli.pcs.capstoneProject.models;

import java.util.Date;

public class BankAccount {
	private int id;
	private int bankId;
	private String agencyNumber;
	private String accountNumber;
	private String accountOwnerName;
	private String accountOwnerCPF;
	private Date accountOwnerBirthdayDate;
	private String token;
	private Bank bank;
	public int getId() {
		return id;
	}
	public int getBankId() {
		return bankId;
	}
	public String getAgencyNumber() {
		return agencyNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getAccountOwnerName() {
		return accountOwnerName;
	}
	public String getAccountOwnerCPF() {
		return accountOwnerCPF;
	}
	public Date getAccountOwnerBirthdayDate() {
		return accountOwnerBirthdayDate;
	}
	public String getToken() {
		return token;
	}
	public Bank getBank() {
		return bank;
	}
}
