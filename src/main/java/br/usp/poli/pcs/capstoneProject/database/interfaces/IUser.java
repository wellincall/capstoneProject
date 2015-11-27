package br.usp.poli.pcs.capstoneProject.database.interfaces;

import java.util.Map;
import java.util.List;
import org.sql2o.Sql2o;

import br.usp.poli.pcs.capstoneProject.models.User;

public interface IUser {
	public User createUser(Sql2o sql2o, Map<String, Object> userInformation);
	public User getUser(Sql2o sql2o, Map<String, Object> userInformation);
	public boolean authenticatesUser(Sql2o sql2o, Map<String, Object>userLogin);
	public User editUser(Sql2o sql2o, Map<String, Object> newUserInformation);
	public List<User> getPlataformUsers(Sql2o sql2o, List<String> phoneNumbers);
	public boolean updatePassword(Sql2o sql2o, int userId, String currentPassword, String newPassword);
	
}
