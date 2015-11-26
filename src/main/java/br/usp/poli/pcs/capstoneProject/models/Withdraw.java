package br.usp.poli.pcs.capstoneProject.models;

public class Withdraw {
	int id;
	int bankId;
	String accountToken;
	int transferIntentionId;
	double value;
	int status;
	TransferIntention transferIntention;
}
