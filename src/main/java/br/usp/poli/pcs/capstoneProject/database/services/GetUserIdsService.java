package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUser;
import br.usp.poli.pcs.capstoneProject.database.implementations.UserDAO;
import java.util.List;

public class GetUserIdsService extends DatabaseService {
	
	private IUser dao;
	
	public GetUserIdsService() {
		super();
		dao = new UserDAO();
	}
	
	public List<Integer> call() {
		return dao.getUsersId(db.getConnection());
	}
}
