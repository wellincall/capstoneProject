package br.usp.poli.pcs.capstoneProject.dataHandler;

import spark.Request;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

import br.usp.poli.pcs.capstoneProject.forms.NewUserForm;
import br.usp.poli.pcs.capstoneProject.helpers.StringToDateService;
import br.usp.poli.pcs.capstoneProject.forms.FormField;

public class RegisterUserDataHandlerService implements IDataHandlerService {
	public Map<String, Object> call(Request request) {
		Map<String, Object> userInformation = new HashMap<String, Object>();
		NewUserForm form = new NewUserForm();
		for (FormField field : form.getFormFields()) {
			if (field.getFormFieldId().equals("birthday-date")) {
				Date birthdayDate = StringToDateService.call(request.queryParams(field.getFormFieldId()));
				userInformation.put(field.getFormFieldId(), birthdayDate);
			} else {
				userInformation.put(field.getFormFieldId(), request.queryParams(field.getFormFieldId()));
			}
		}
		return userInformation;
	}
}
