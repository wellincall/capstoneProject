package br.usp.poli.pcs.capstoneProject.models;

public class UserBankAccount {
	private int id;
	private int userId;
	private String accountToken;
	private User owner;
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public String getAccountToken() {
		return accountToken;
	}
	public User getOwner() {
		return owner;
	}
}
