package br.usp.poli.pcs.captstoneProject.models;

public class Withdraw {
	int id;
	int bankId;
	String accountToken;
	int transferIntentionId;
	double value;
	int status;
	TransferIntention transferIntention;
}
