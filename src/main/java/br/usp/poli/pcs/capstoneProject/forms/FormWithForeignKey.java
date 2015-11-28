package br.usp.poli.pcs.capstoneProject.forms;

import br.usp.poli.pcs.capstoneProject.forms.components.ForeignKeyField;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import spark.Request;

public abstract class FormWithForeignKey extends Form {
	public boolean isValid(Request request) {
		boolean isValid = true;
		for (FormField formField : formFields) {
			if (formField instanceof ForeignKeyField) {
				int foreignKeyValue = Integer.valueOf(request.queryParams(formField.getFormFieldId()));
				if (!((ForeignKeyField) formField).validates(foreignKeyValue)) {
					isValid = false;
				}
			} else {
				String paramInRequest = request.queryParams(formField.getFormFieldId());
				if (paramInRequest == null || !formField.validates(paramInRequest)) {
					isValid = false;
				}
			}
			
		}
		return isValid;
	}
}
