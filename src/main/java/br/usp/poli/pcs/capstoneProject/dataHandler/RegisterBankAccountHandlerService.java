package br.usp.poli.pcs.capstoneProject.dataHandler;

import java.util.Map;
import java.util.HashMap;
import spark.Request;
import br.usp.poli.pcs.capstoneProject.forms.NewBankAccountForm;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.FormField;

public class RegisterBankAccountHandlerService implements IDataHandlerService {

	public Map<String, Object> call(Request request) {
		Map<String, Object> bankAccountInfo = new HashMap<String, Object>();
		Form bankAccountForm = new NewBankAccountForm();
		for (FormField formField : bankAccountForm.getFormFields()) {
			bankAccountInfo.put(formField.getFormFieldId(), request.queryParams(formField.getFormFieldId()));
		}
		return bankAccountInfo;
	}

}
