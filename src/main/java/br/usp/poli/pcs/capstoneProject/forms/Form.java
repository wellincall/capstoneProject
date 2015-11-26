package br.usp.poli.pcs.capstoneProject.forms;

import java.util.List;
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
				System.out.println("Didn't validate: "+paramInRequest+" for "+formField.getFormFieldId());
				isValid = false;
			}
		}
		return isValid;
	}
}
