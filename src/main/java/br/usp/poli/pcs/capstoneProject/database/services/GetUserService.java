package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.implementations.UserDAO;
import br.usp.poli.pcs.capstoneProject.models.User;
import java.util.Map;

public class GetUserService extends DatabaseService{
	
	private UserDAO dao;
	
	public GetUserService() {
		super();
		dao = new UserDAO();
	}
	
	public User call(Map<String, Object> userInformation) {
		return dao.getUser(db.getConnection(), userInformation);
	}
}
