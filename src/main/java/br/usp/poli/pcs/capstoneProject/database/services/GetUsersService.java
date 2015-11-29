package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUser;
import br.usp.poli.pcs.capstoneProject.database.implementations.UserDAO;
import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.User;

public class GetUsersService extends DatabaseService {
	
	private IUser dao;
	
	public GetUsersService() {
		super();
		dao = new UserDAO();
	}
	
	public List<User> call() {
		return dao.getUsers(db.getConnection());
	}
}
