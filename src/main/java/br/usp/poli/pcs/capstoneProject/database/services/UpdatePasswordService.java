package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.implementations.UserDAO;
import java.util.Map;

public class UpdatePasswordService extends DatabaseService{
	private UserDAO dao;
	
	public UpdatePasswordService() {
		super();
		dao = new UserDAO();
	}
	
	public boolean call(Map<String, Object> passwordInformation) {
		return dao.updatePassword(db.getConnection(), passwordInformation);
	}
	
}
