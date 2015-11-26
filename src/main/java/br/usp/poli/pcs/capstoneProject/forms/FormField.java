package br.usp.poli.pcs.capstoneProject.forms;

public class FormField {
	private String formFieldId;
	private String formFieldCaption;
	private String formFieldType; 
	
	protected FormField(String formFieldId, String formFieldCaption, String formFieldType) {
		this.formFieldId = formFieldId;
		this.formFieldCaption = formFieldCaption;
		this.formFieldType = formFieldType;
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
	
}
