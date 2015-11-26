package br.usp.poli.pcs.capstoneProject.forms;

public class NewUserForm extends Form {
	public NewUserForm() {
		super();
		formFields.add(new FormField("name", "Name", "text"));
		formFields.add(new FormField("phone-number", "Phone Number", "text"));
		formFields.add(new FormField("cpf", "CPF", "text"));
		formFields.add(new FormField("email", "E-mail", "email"));
		formFields.add(new FormField("birthday-date", "Birthday Date", "text"));
		formFields.add(new FormField("password", "Password", "password"));
	}
}
