package br.usp.poli.pcs.capstoneProject.dataHandler;

import java.util.Map;
import java.util.HashMap;
import spark.Request;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.ResetPasswordForm;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;

public class UpdatePasswordDataHandlerService implements IDataHandlerService {
	public Map<String, Object> call(Request request) {
		Map<String, Object> passwordInformation = new HashMap<String, Object>();
		Form passwordForm = new ResetPasswordForm();
		for(FormField field: passwordForm.getFormFields()) {
			passwordInformation.put(field.getFormFieldId(), request.queryParams(field.getFormFieldId()));
		}
		return passwordInformation;
	}
}
