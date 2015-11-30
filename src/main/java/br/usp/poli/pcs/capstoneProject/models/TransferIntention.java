package br.usp.poli.pcs.capstoneProject.models;

import java.util.Date;

public class TransferIntention {
	public static final int CREATED = 0;
	public static final int DECLINED = 1;
	public static final int ACCEPTED = 2;
	public static final int VOIDED = 3;
	public static final int CONSOLIDATED = 4;
	private int id;
	private double value;
	private int recipientId;
	private int senderId;
	private int status;
	private Withdraw withdraw;
	private Deposit deposit;
	private Date creationDate;
	public static int getCreated() {
		return CREATED;
	}
	public int getId() {
		return id;
	}
	public double getValue() {
		return value;
	}
	public int getRecipientId() {
		return recipientId;
	}
	public int getSenderId() {
		return senderId;
	}
	public int getStatus() {
		return status;
	}
	public Withdraw getWithdraw() {
		return withdraw;
	}
	public Deposit getDeposit() {
		return deposit;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	
	public String statusToHuman() {
		switch (status) {
		case CREATED: 
			return "created";
		case DECLINED:
			return "declined";
		case ACCEPTED:
			return "accepted";
		case VOIDED:
			return "voided";
		default:
			return "invalid";
		}
	}
	
	public boolean isCreated() {
		return status == CREATED;
	}
	
	public boolean isDeclined() {
		return status == DECLINED;
	}
	
	public boolean isAccepted() {
		return status == ACCEPTED;
	}
	
	public boolean isVoided() {
		return status == VOIDED;
	}
	
	
	
}
