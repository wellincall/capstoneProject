package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUser;
import br.usp.poli.pcs.capstoneProject.database.implementations.UserDAO;

public class UserVerificationService extends DatabaseService {
	
	private IUser dao;
	
	public UserVerificationService() {
		super();
		dao = new UserDAO();
	}
	
	public boolean call(int userId, String providedVerificationCode) {
		return dao.verifiesUser(db.getConnection(), userId, providedVerificationCode);
	}
}
