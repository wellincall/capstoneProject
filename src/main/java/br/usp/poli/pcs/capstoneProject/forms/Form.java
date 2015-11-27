package br.usp.poli.pcs.capstoneProject.forms;

import java.util.List;

import br.usp.poli.pcs.capstoneProject.forms.components.FormField;

import java.util.ArrayList;
import spark.Request;

public abstract class Form {
	protected List<FormField> formFields;
	public Form() {
		formFields = new ArrayList<FormField>();
	}
	public List<FormField> getFormFields() {
		return formFields;
	}
	
	public boolean isValid(Request request) {
		boolean isValid = true;
		for (FormField formField : formFields) {
			String paramInRequest = request.queryParams(formField.getFormFieldId());
			if (paramInRequest == null || !formField.validates(paramInRequest)) {
				isValid = false;
			}
		}
		return isValid;
	}
}
