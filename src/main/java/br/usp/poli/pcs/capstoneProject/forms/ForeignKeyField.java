package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.fieldValidators.IForeignKeyValidator;
import java.util.Map;
import java.util.Set;

public class ForeignKeyField extends FormField {
	private IForeignKeyValidator validator;
	private Map<String, String> options;
	
	public ForeignKeyField(String formFieldId, String formFieldCaption, IForeignKeyValidator validator, Map<String, String> options) {
		this.formFieldId = formFieldId; 
		this.formFieldCaption = formFieldCaption;
		this.validator = validator;
		this.options = options;
	}
	
	public boolean validates(int foreignKey) {
		return validator.validates(foreignKey);
	}
	
	public Map<String, String> getOptions() {
		return options;
	}
}
