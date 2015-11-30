package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;

import br.usp.poli.pcs.capstoneProject.forms.NewUserForm;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.dataHandler.IDataHandlerService;
import br.usp.poli.pcs.capstoneProject.dataHandler.RegisterUserDataHandlerService;
import br.usp.poli.pcs.capstoneProject.database.implementations.UserDAO;
import br.usp.poli.pcs.capstoneProject.database.interfaces.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.database.interfaces.IUser;
import br.usp.poli.pcs.capstoneProject.models.User;


public class RegisterUserHandler extends DefaultPostHandler {
	public RegisterUserHandler(Request request, Response response) {
		super(request, response);
	}
	public String process() {
		Form form = new NewUserForm();
		if (form.isValid(request)) {
			User user = persistUser();
			if (user != null) {
				return "{\"status\": 0, \"message\": \"User successfully registered \"}";
			} else {
				return "{\"status\": 1, \"message\": \"User already registered\"}";
			}
		} else {
			return "{\"status\": 2, \"message\": \"Missing information or invalid information when trying to register user\"}";
		}
	}
	
	private User persistUser() {
		CapstoneConnection db = new CapstoneConnection();
		IDataHandlerService dataHandler = new RegisterUserDataHandlerService();
		Map<String, Object> userInfo = dataHandler.call(request);
		IUser dao = new UserDAO();
		return dao.createUser(db.getConnection(), userInfo);
	}
}
