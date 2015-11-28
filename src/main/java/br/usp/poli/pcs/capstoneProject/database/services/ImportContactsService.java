package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.implementations.UserDAO;
import br.usp.poli.pcs.capstoneProject.models.User;
import java.util.List;

public class ImportContactsService extends DatabaseService {
	private UserDAO dao;
	
	public ImportContactsService() {
		super();
		dao = new UserDAO();
	}
	
	public List<User> call(List<String> phoneNumbers) {
		return dao.getPlataformUsers(db.getConnection(), phoneNumbers);
	}
}
