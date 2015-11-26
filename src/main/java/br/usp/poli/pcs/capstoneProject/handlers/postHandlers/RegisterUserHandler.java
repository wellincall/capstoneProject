package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;

import br.usp.poli.pcs.capstoneProject.forms.NewUserForm;
import br.usp.poli.pcs.capstoneProject.databaseInterface.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.dataHandler.RegisterUserDataHandlerService;
import br.usp.poli.pcs.capstoneProject.databaseInterface.IUser;
import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.databaseImplementation.UserDAO;


public class RegisterUserHandler extends DefaultPostHandler {
	public RegisterUserHandler(Request request, Response response) {
		super(request, response);
	}
	public String process() {
		NewUserForm form = new NewUserForm();
		if (form.isValid(request)) {
			persistUser();
			return "{Success: 'Check DB'}";
		} else {
			return "{Error: \"Motherfucker\"}";
		}
	}
	
	private User persistUser() {
		CapstoneConnection db = new CapstoneConnection();
		RegisterUserDataHandlerService dataHandler = new RegisterUserDataHandlerService();
		Map<String, Object> userInfo = dataHandler.call(request);
		IUser dao = new UserDAO();
		return dao.createUser(db.getConnection(), userInfo);
	}
}
