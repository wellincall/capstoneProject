package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.fieldValidators.IValidator;


public class FormField {
	private String formFieldId;
	private String formFieldCaption;
	private String formFieldType; 
	private IValidator validator;
	
	protected FormField(String formFieldId, String formFieldCaption, String formFieldType, IValidator validator) {
		this.formFieldId = formFieldId;
		this.formFieldCaption = formFieldCaption;
		this.formFieldType = formFieldType;
		this.validator = validator;
	}
	
	public String getFormFieldId() {
		return formFieldId;
	}
	
	public String getFormFieldCaption() {
		return formFieldCaption;
	}
	
	public String getFormFieldType() {
		return formFieldType;
	}
	
	public boolean validates(String value) {
		return validator.validates(value);
	}
	
}
