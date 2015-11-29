package br.usp.poli.pcs.capstoneProject.models;

public class TransferIntention {
	public static final int CREATED = 0;
	public static final int DECLINED = 1;
	public static final int ACCEPTED = 2;
	public static final int VOIDED = 3;
	public static final int VISUALIZED = 4;
	public static final int CONSOLIDATED = 5;
	private int id;
	private double value;
	private int recipientId;
	private int senderId;
	private int status;
	private Withdraw withdraw;
	private Deposit deposit;
}
