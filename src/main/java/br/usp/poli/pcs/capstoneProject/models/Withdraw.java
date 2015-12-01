package br.usp.poli.pcs.capstoneProject.models;

import java.util.Date;

public class Withdraw {
	public static final int CREATED = 0;
	public static final int DECLINED = 1;
	public static final int ACCEPTED = 2;
	public static final int VOIDED = 3;
	public static final int CONSOLIDATED = 4;
	private int id;
	private int bankId;
	private String accountToken;
	private int transferIntentionId;
	private double value;
	private int status;
	private Date creationDate;
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
	public Date getCreationDate() {
		return creationDate;
	}
	public TransferIntention getTransferIntention() {
		return transferIntention;
	}
	public boolean canBeDeclined() {
		return status == CREATED;
	}
	
	public boolean canBeVoided() {
		return status == CREATED || status == ACCEPTED;
	}
	
	public boolean canBeAccepted() {
		return status == CREATED;
	}
	
	public boolean canBeConsolidated() {
		return status == ACCEPTED;
	}
}
