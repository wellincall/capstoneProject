package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.Map;
import java.util.List;
import org.sql2o.Sql2o;

import br.usp.poli.pcs.capstoneProject.models.User;

public interface IUser {
	public User createUser(Sql2o sql2o, Map<String, Object> userInformation);
	public User getUser(Sql2o sql2o, Map<String, Object> userInformation);
	public User getUserById(Sql2o sql2o, int userId);
	public boolean authenticatesUser(Sql2o sql2o, Map<String, Object>userLogin);
	public List<User> getPlataformUsers(Sql2o sql2o, String[] phoneNumbers);
	public boolean updatePassword(Sql2o sql2o, Map<String, Object> passwordInformation);
	public List<Integer> getUsersId(Sql2o sql2o);
	public List<User> getUsers(Sql2o sql2o);
	public boolean verifiesUser(Sql2o sql2o, int userId, String verificationCode);
}
