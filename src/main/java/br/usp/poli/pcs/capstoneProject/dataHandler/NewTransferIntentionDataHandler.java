package br.usp.poli.pcs.capstoneProject.dataHandler;

import spark.Request;
import java.util.Map;
import java.util.HashMap;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.forms.NewTransferIntentionForm;


public class NewTransferIntentionDataHandler implements IDataHandlerService {
	public Map<String, Object> call(Request request) {
		Form form = new NewTransferIntentionForm(request.session().attribute("user-id"));
		Map<String, Object> transferInfo = new HashMap<String, Object>();
		for(FormField formField : form.getFormFields()) {
			transferInfo.put(formField.getFormFieldId(), request.queryParams(formField.getFormFieldId()));
		}
		transferInfo.put("sender-id", request.session().attribute("user-id"));
		return transferInfo;
	}
}
