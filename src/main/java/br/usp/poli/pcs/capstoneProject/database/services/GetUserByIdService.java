package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.implementations.UserDAO;
import br.usp.poli.pcs.capstoneProject.models.User;

public class GetUserByIdService extends DatabaseService{
	
	private UserDAO dao;
	
	public GetUserByIdService() {
		super();
		dao = new UserDAO();
	}
	
	public User call(int userId) {
		return dao.getUserById(db.getConnection(), userId);
	}
}
