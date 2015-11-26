package br.usp.poli.pcs.capstoneProject.models;

import java.util.Date;
import java.util.List;

public class User {
	int id;
	String name;
	String phoneNumber;
	String email;
	Date birthdayDate;
	Date creationDate;
	String password;
	List<BankAccount> accounts;
}
