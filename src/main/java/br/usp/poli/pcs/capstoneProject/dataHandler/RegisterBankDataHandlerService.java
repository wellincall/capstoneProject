package br.usp.poli.pcs.capstoneProject.dataHandler;

import java.util.Map;
import java.util.HashMap;
import spark.Request;

import br.usp.poli.pcs.capstoneProject.forms.NewBankForm;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;

public class RegisterBankDataHandlerService implements IDataHandlerService{
	public Map<String, Object> call(Request request) {
		Map<String, Object> bankInfo = new HashMap<String, Object>();
		NewBankForm bankForm = new NewBankForm();
		for (FormField field : bankForm.getFormFields()) {
			bankInfo.put(field.getFormFieldId(), request.queryParams(field.getFormFieldId()));
		}
		return bankInfo;
	}
}
