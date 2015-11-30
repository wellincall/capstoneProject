package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.ResetPasswordForm;
import br.usp.poli.pcs.capstoneProject.database.services.AuthenticationService;
import br.usp.poli.pcs.capstoneProject.database.services.UpdatePasswordService;
import br.usp.poli.pcs.capstoneProject.dataHandler.IDataHandlerService;
import br.usp.poli.pcs.capstoneProject.dataHandler.UpdatePasswordDataHandlerService;
import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserByIdService;
import java.util.Map;



public class UpdatePasswordHandler extends DefaultPostHandler {
	
	private IDataHandlerService dataHandler;
	
	public UpdatePasswordHandler(Request request, Response response) {
		super(request, response);
		dataHandler = new UpdatePasswordDataHandlerService();
	}

	public String process() {
		Form form = new ResetPasswordForm();
		if (form.isValid(request)) {
			Map<String, Object> passwordFields = dataHandler.call(request);
			User user = (new GetUserByIdService()).call(request.session().attribute("user-id"));
			passwordFields.put("email", user.getEmail());
			passwordFields.put("user-id", user.getId());
			if (canUpdatePassword(passwordFields)) {
				(new UpdatePasswordService()).call(passwordFields);
				return "{\"status\": 0, \"message\": \"Password successfully updated\"}";
			} else {
				return "{\"status\": 1, \"message\": \"New password and its confirmation don't match or given passeword is incorrect \"}";
			}
		} else {
			return "{\"status\": 2, \"message\": \"Missing information or invalid data to update password\"}";
		}
	}
	

	
	private boolean canUpdatePassword(Map<String, Object> passwordFields) {
		return matchInNewPassword(passwordFields) && providedCorrectCurrentPassword(passwordFields);
	}
	
	private boolean providedCorrectCurrentPassword(Map<String, Object> passwordFields) {
		return (new AuthenticationService()).call(passwordFields);
	}

	private boolean matchInNewPassword(Map<String, Object> passwordFields) {
		return passwordFields.get("new-password").equals(passwordFields.get("password-confirmation"));
	}
}
