package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.implementations.UserDAO;

import java.util.Map;
import java.util.HashMap;
import spark.Request;

public class AuthenticationService extends DatabaseService{
	
	private UserDAO dao;
	
	public AuthenticationService() {
		super();
		dao = new UserDAO();
	}
	
	private Map<String, Object> prepare(Request request) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (request.queryMap("email") != null) {
				parameters.put("email", request.queryParams("email"));
		}
		if (request.queryMap("phone-number") != null) {
			parameters.put("phone-number", request.queryParams("phone-number"));
		}
		parameters.put("password", request.queryParams("password"));
		return parameters;
	}
	
	public boolean call(Request request) {
		return dao.authenticatesUser(db.getConnection(), prepare(request));
	}
	
	
}
