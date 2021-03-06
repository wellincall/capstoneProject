package br.usp.poli.pcs.capstoneProject.database.implementations;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;


import org.sql2o.Sql2o;
import org.sql2o.Connection;

import br.usp.poli.pcs.capstoneProject.database.interfaces.IUser;
import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.security.NewPasswordHashService;
import br.usp.poli.pcs.capstoneProject.security.PasswordHashService;
import br.usp.poli.pcs.capstoneProject.security.VerificationCodeGenerator;

public class UserDAO implements IUser{

	@Override
	public User createUser(Sql2o sql2o, Map<String, Object> userInformation) {
		User user = null;
		String hashedPassword = (new NewPasswordHashService()).call((String) userInformation.get("password"));
		String verificationCode = (new VerificationCodeGenerator()).call();
		try(Connection connection = sql2o.beginTransaction()) {
			if (canRegisterUser(connection, userInformation)) {
				int userId = connection.createQuery("INSERT INTO users(name, phoneNumber," 
						+ "cpf, email, birthdayDate, password, creationDate, verificationCode, isverified) "
						+ "VALUES (:name, :phoneNumber, :cpf, :email, :birthdayDate, "
						+ ":password, :creationDate, :verificationCode, false)", true)
					.addParameter("name", (String) userInformation.get("name"))
					.addParameter("phoneNumber", (String) userInformation.get("phone-number"))
					.addParameter("cpf", (String) userInformation.get("cpf"))
					.addParameter("email", (String) userInformation.get("email"))
					.addParameter("password", hashedPassword)
					.addParameter("verificationCode", verificationCode)
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
	public User getUser(Sql2o sql2o, Map<String, Object> userInformation) {
		User user = null;
		try (Connection connection = sql2o.beginTransaction()) {
			if (userInformation.get("email") != null) {
				user = connection.createQuery("SELECT * FROM users WHERE email = :email")
						.addParameter("email", userInformation.get("email"))
						.executeAndFetchFirst(User.class);
			} else if (userInformation.get("phone-number") != null) {
				user = connection.createQuery("SELECT * FROM users WHERE phoneNumber = :phoneNumber")
						.addParameter("phoneNumber", userInformation.get("phone-number"))
						.executeAndFetchFirst(User.class);
			}
		}
		return user;
	}
	
	public User getUserById(Sql2o sql2o, int userId) {
		User user = null;
		try (Connection connection = sql2o.beginTransaction()){
			user = connection.createQuery("SELECT * FROM users WHERE id = :id")
					.addParameter("id", userId)
					.executeAndFetchFirst(User.class);
			connection.commit();
		}
		return user;
	}
	@Override
	public boolean authenticatesUser(Sql2o sql2o, Map<String, Object> userLogin) {
		try(Connection connection = sql2o.beginTransaction()) {
			String salt = getUserSalt(connection, userLogin);
			String secret = salt + userLogin.get("password");
			String hashedSecret = (new PasswordHashService()).call(secret);
			String dataInDB = salt + hashedSecret;
			if (userLogin.get("email") != null) {
				int usersFound = connection.createQuery("SELECT count(id) FROM users WHERE "
						+ "password = :secret AND email = :email")
						.addParameter("secret", dataInDB)
						.addParameter("email", userLogin.get("email"))
						.executeScalar(Integer.class);
				return usersFound == 1;
			} else if (userLogin.get("phone-number") != null) {
				int usersFound = connection.createQuery("SELECT count(id) FROM users WHERE "
						+ "password = :secret AND phoneNumber = :phoneNumber")
						.addParameter("secret", dataInDB)
						.addParameter("phoneNumber", userLogin.get("phone-number"))
						.executeScalar(Integer.class);
				return usersFound == 1;
			} else {
				connection.commit();
				return false;
			}
		}
	}

	@Override
	public List<User> getPlataformUsers(Sql2o sql2o, String[] phoneNumbers) {
		List<User> registeredUsers = new ArrayList<User>();
		try(Connection connection = sql2o.beginTransaction()) {
			for (String phoneNumber : phoneNumbers) {
				User user = connection.createQuery("SELECT id, name, phoneNumber FROM users WHERE phoneNumber::TEXT LIKE :phoneNumber")
						.addParameter("phoneNumber", "%" + phoneNumber)
						.executeAndFetchFirst(User.class);
				if (user != null) {
					registeredUsers.add(user);
				}
			}
			connection.commit();
		}
		return registeredUsers;
	}


	@Override
	public boolean updatePassword(Sql2o sql2o, Map<String, Object> passwordInformation) {
		try (Connection connection = sql2o.beginTransaction()) {
			if (authenticatesUser(sql2o, passwordInformation)) {
				String newPassword = (new NewPasswordHashService()).call(String.valueOf(passwordInformation.get("new-password")));
				connection.createQuery("UPDATE users SET password = :password WHERE id = :id")
					.addParameter("password", newPassword)
					.addParameter("id", passwordInformation.get("user-id"))
					.executeUpdate();
				connection.commit();
				return true;
			}
			connection.commit();
		}
		return false;
	}
	
	private boolean canRegisterUser(Connection connection, Map<String, Object> userInformation) {
		int usersRegistered = connection.createQuery("SELECT count(id) FROM users WHERE"
				+ " cpf = :cpf")
				.addParameter("cpf", userInformation.get("cpf"))
				.executeScalar(Integer.class);
		int phonesRegistered = connection.createQuery("SELECT count(id) FROM users WHERE"
				+ " phoneNumber = :phoneNumber")
				.addParameter("phoneNumber", userInformation.get("phone-number"))
				.executeScalar(Integer.class);
		int emailsRegistered = connection.createQuery("SELECT count(id) FROM users WHERE"
				+ " email = :email")
				.addParameter("email", userInformation.get("email"))
				.executeScalar(Integer.class);
		return usersRegistered == 0 && phonesRegistered == 0 && emailsRegistered == 0;
	}
	
	private String getUserSalt(Connection connection, Map<String, Object> userInformation) {
		StringBuffer salt = new StringBuffer();
		if (userInformation.get("email") != null) {
			salt.append(connection.createQuery("SELECT password FROM users WHERE email = :email")
					.addParameter("email", userInformation.get("email"))
					.executeScalar(String.class));
		} else if (userInformation.get("phone-number") != null) {
			salt.append(connection.createQuery("SELECT password FROM users WHERE phoneNumber = :phoneNumber")
					.addParameter("phoneNumber", userInformation.get("phone-number"))
					.executeScalar(String.class));
		}
		return salt.toString().substring(0, 2);
	}

	@Override
	public List<Integer> getUsersId(Sql2o sql2o) {
		Connection connection = sql2o.beginTransaction();
		List<Integer> ids = connection.createQuery("SELECT id FROM users").executeAndFetch(Integer.class);
		connection.commit();
		return ids;
	}

	@Override
	public List<User> getUsers(Sql2o sql2o) {
		List<User> users = null;
		Connection connection = sql2o.beginTransaction();
		users = connection.createQuery("SELECT id, name, phonenumber FROM users").executeAndFetch(User.class);
		connection.commit();
		return users;
	}

	@Override
	public boolean verifiesUser(Sql2o sql2o, int userId, String verificationCode) {
		try (Connection connection = sql2o.beginTransaction()) {
			User user = connection.createQuery("SELECT * FROM users WHERE id = :userId")
							.addParameter("userId", userId)
							.executeAndFetchFirst(User.class);
			if (user.verifiesWith(verificationCode.toUpperCase())) {
				connection.createQuery("UPDATE users SET isverified = true WHERE id = :userId")
						.addParameter("userId", userId)
						.executeUpdate();
			} 
			
			connection.commit();
			return user.verifiesWith(verificationCode);
		}
	}

	@Override
	public boolean isVerified(Sql2o sql2o, int userId) {
		boolean userIsVerified = false;
		try (Connection connection = sql2o.beginTransaction()) {
			userIsVerified = connection.createQuery("SELECT isVerified FROM users WHERE id = :userId")
								.addParameter("userId", userId)
								.executeAndFetchFirst(Boolean.class);
			connection.commit();
		}
		return userIsVerified;
	}
	

}
