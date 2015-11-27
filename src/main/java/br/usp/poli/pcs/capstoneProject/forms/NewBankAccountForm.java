package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.fieldValidators.BankForeignKeyValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.TextFieldValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.BankAccountNumberValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.BankAgencyValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.CPFValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.DateValidator;
import br.usp.poli.pcs.capstoneProject.fieldValidators.PhoneNumberValidator;
import br.usp.poli.pcs.capstoneProject.models.Bank;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class NewBankAccountForm extends FormWithForeignKey {
	public NewBankAccountForm(){
		formFields.add(new ForeignKeyField("bank-id", "Bank", new BankForeignKeyValidator(), generateOptions(new ArrayList<Bank>())));
		formFields.add(new FormField("agency-number", "Agency Number", "text", new BankAgencyValidator()));
		formFields.add(new FormField("account-number", "Account Number", "text", new BankAccountNumberValidator()));
		formFields.add(new FormField("account-owner-name", "Owner Name", "text", new TextFieldValidator()));
		formFields.add(new FormField("account-owner-cpf", "Owner CPF", "text", new CPFValidator()));
		formFields.add(new FormField("account-owner-birthday-date", "Owner Birthday Date", "text", new DateValidator()));
		formFields.add(new FormField("account-owner-phone-number", "Owner Phone Number", "text", new PhoneNumberValidator())); 
	}
	
	public NewBankAccountForm(List<Bank> banks) {
		super();
		formFields.add(new ForeignKeyField("bank-id", "Bank", new BankForeignKeyValidator(), generateOptions(banks)));
		formFields.add(new FormField("agency-number", "Agency Number", "text", new BankAgencyValidator()));
		formFields.add(new FormField("account-number", "Account Number", "text", new BankAccountNumberValidator()));
		formFields.add(new FormField("account-owner-name", "Owner Name", "text", new TextFieldValidator()));
		formFields.add(new FormField("account-owner-cpf", "Owner CPF", "text", new CPFValidator()));
		formFields.add(new FormField("account-owner-birthday-date", "Owner Birthday Date", "text", new DateValidator()));
		formFields.add(new FormField("account-owner-phone-number", "Owner Phone Number", "text", new PhoneNumberValidator())); 
	}
	
	
	
	private Map<String, String> generateOptions(List<Bank> banks) {
		Map<String, String> options = new HashMap<String, String>();
		for (Bank bank : banks) {
			options.put(String.valueOf(bank.getId()), bank.getName());
		}
		return options;
	}
}
