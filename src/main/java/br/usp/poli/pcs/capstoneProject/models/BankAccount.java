package br.usp.poli.pcs.capstoneProject.models;

import java.util.Date;

public class BankAccount {
	int id;
	int bankId;
	String agencyNumber;
	String accountNumer;
	String accountOwnerName;
	String accountOwnerCPF;
	Date accountOwnerBirthdayDate;
	String token;
	Bank bank;
}
