package br.usp.poli.pcs.capstoneProject.dataHandler;

import java.util.Map;
import java.util.HashMap;
import spark.Request;
import br.usp.poli.pcs.capstoneProject.forms.NewAccountAssociationForm;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;

public class AssociateBankAccountHandlerService implements IDataHandlerService {
	public Map<String, Object> call(Request request) {
		Form form = new NewAccountAssociationForm();
		Map<String, Object> formData = new HashMap<String, Object>();
		for (FormField field : form.getFormFields()) {
			formData.put(field.getFormFieldId(), request.queryParams(field.getFormFieldId()));
		}
		return formData;
	}
}
