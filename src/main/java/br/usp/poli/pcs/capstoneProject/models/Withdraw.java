package br.usp.poli.pcs.capstoneProject.models;

public class Withdraw {
	private int id;
	private int bankId;
	private String accountToken;
	private int transferIntentionId;
	private double value;
	private int status;
	private TransferIntention transferIntention;
	public int getId() {
		return id;
	}
	public int getBankId() {
		return bankId;
	}
	public String getAccountToken() {
		return accountToken;
	}
	public int getTransferIntentionId() {
		return transferIntentionId;
	}
	public double getValue() {
		return value;
	}
	public int getStatus() {
		return status;
	}
	public TransferIntention getTransferIntention() {
		return transferIntention;
	}
}
