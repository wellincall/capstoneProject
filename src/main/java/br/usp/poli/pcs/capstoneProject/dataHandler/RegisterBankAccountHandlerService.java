package br.usp.poli.pcs.capstoneProject.dataHandler;

import java.util.Map;
import java.util.HashMap;
import spark.Request;
import br.usp.poli.pcs.capstoneProject.forms.NewBankAccountForm;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.helpers.StringToDateService;

public class RegisterBankAccountHandlerService implements IDataHandlerService {

	public Map<String, Object> call(Request request) {
		Map<String, Object> bankAccountInfo = new HashMap<String, Object>();
		Form bankAccountForm = new NewBankAccountForm();
		for (FormField formField : bankAccountForm.getFormFields()) {
			if(formField.getFormFieldId().contains("birthday-date")) {
				bankAccountInfo.put(formField.getFormFieldId(), StringToDateService.call(request.queryParams(formField.getFormFieldId())));
			} else if (formField.getFormFieldId().contains("id")) {
				bankAccountInfo.put(formField.getFormFieldId(), Integer.valueOf(request.queryParams(formField.getFormFieldId())));
			} else {
				bankAccountInfo.put(formField.getFormFieldId(), request.queryParams(formField.getFormFieldId()));
			}
		}
		return bankAccountInfo;
	}

}
