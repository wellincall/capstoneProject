package br.usp.poli.pcs.capstoneProject.models;

import java.util.Date;
import java.util.List;

public class User {
	private int id;
	private String name;
	private String cpf;
	private String phoneNumber;
	private String email;
	private Date birthdayDate;
	private Date creationDate;
	private String password;
	private boolean isVerified;
	private String verificationCode;
	private List<BankAccount> accounts;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public Date getBirthdayDate() {
		return birthdayDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public String getPassword() {
		return password;
	}
	public List<BankAccount> getAccounts() {
		return accounts;
	}
	public String getCpf() {
		return cpf;
	}
	public boolean isVerified() {
		return isVerified;
	}
	
	public String getVerificationCode() {
		return verificationCode;
	}
	public boolean verifiesWith(String providedVerificationCode) {
		return verificationCode.equals(providedVerificationCode);
	}
}
