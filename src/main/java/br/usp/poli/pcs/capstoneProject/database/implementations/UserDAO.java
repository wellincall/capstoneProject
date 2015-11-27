package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.Map;
import java.util.Date;


import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUser;
import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.security.NewPasswordHashService;

public class UserDAO implements IUser{

	@Override
	public User createUser(Sql2o sql2o, Map<String, Object> userInformation) {
		User user = null;
		String hashedPassword = (new NewPasswordHashService()).call((String) userInformation.get("password"));
		try(Connection connection = sql2o.beginTransaction()) {
			if (canRegisterUser(connection, userInformation)) {
				int userId = connection.createQuery("INSERT INTO users(name, phoneNumber," 
						+ "cpf, email, birthdayDate, password, creationDate) "
						+ "VALUES (:name, :phoneNumber, :cpf, :email, :birthdayDate, "
						+ ":password, :creationDate)", true)
					.addParameter("name", (String) userInformation.get("name"))
					.addParameter("phoneNumber", (String) userInformation.get("phone-number"))
					.addParameter("cpf", (String) userInformation.get("cpf"))
					.addParameter("email", (String) userInformation.get("email"))
					.addParameter("password", hashedPassword)
					.addParameter("birthdayDate", userInformation.get("birthday-date"))
					.addParameter("creationDate", new Date())
					.executeUpdate()
					.getKey(Integer.class);
				user = connection.createQuery("SELECT * FROM users WHERE id = :id")
					.addParameter("id", userId)
					.executeAndFetchFirst(User.class);
			}
			connection.commit();
		}
		return user;
	}

	@Override
	public User getUser(Sql2o sql2o, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authenticatesUser(String phoneNumber, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User editUser(Sql2o sql2o, Map<String, Object> newUserInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getPlataformUsers(Sql2o sql2o, List<String> phoneNumbers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setPassword(Sql2o sql2o, int userId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassword(Sql2o sql2o, int userId, String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean canRegisterUser(Connection connection, Map<String, Object> userInformation) {
		int usersRegistered = connection.createQuery("SELECT count(id) FROM users WHERE email = :email"
				+ " AND cpf = :cpf AND phoneNumber = :phoneNumber AND name = :name")
				.addParameter("name", userInformation.get("name"))
				.addParameter("email", userInformation.get("email"))
				.addParameter("cpf", userInformation.get("cpf"))
				.addParameter("phoneNumber", userInformation.get("phone-number"))
				.executeScalar(Integer.class);
		return usersRegistered == 0;
	}

}
