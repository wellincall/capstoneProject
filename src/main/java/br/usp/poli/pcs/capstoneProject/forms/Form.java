package br.usp.poli.pcs.capstoneProject.forms;

import java.util.List;
import java.util.ArrayList;

public abstract class Form {
	protected List<FormField> formFields;
	public Form() {
		formFields = new ArrayList<FormField>();
	}
	public List<FormField> getFormFields() {
		return formFields;
	}
}
