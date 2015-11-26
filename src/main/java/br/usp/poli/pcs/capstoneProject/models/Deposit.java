package br.usp.poli.pcs.capstoneProject.models;

public class Deposit {
	int id;
	int bankId;
	String accountToken;
	int transferIntentionId;
	double value;
	int status;
	TransferIntention transferIntention;
}
