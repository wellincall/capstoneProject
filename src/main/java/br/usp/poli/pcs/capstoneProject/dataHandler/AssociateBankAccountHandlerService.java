package br.usp.poli.pcs.capstoneProject.dataHandler;

import java.util.Map;
import java.util.HashMap;
import spark.Request;
import br.usp.poli.pcs.capstoneProject.forms.NewAccountAssociationForm;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.components.FormField;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserByIdService;
import br.usp.poli.pcs.capstoneProject.models.User;

public class AssociateBankAccountHandlerService implements IDataHandlerService {
	public Map<String, Object> call(Request request) {
		Form form = new NewAccountAssociationForm();
		Map<String, Object> formData = new HashMap<String, Object>();
		for (FormField field : form.getFormFields()) {
			formData.put(field.getFormFieldId(), request.queryParams(field.getFormFieldId()));
		}
		User user = (new GetUserByIdService()).call(request.session().attribute("user-id"));
		formData.put("user-id" , user.getId());
		formData.put("name" , user.getName());
		formData.put("cpf", user.getCpf());
		formData.put("birthday-date", user.getBirthdayDate());
		return formData;
	}
}
