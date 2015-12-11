package br.usp.poli.pcs.capstoneProject.jsonHelpers;

import java.util.List;
import java.util.StringJoiner;
import br.usp.poli.pcs.capstoneProject.models.User;

public class ContactsListToJson {
	public String call(List<User> users) {
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		for (User user : users) {
			StringJoiner userJSON = new StringJoiner(", ", "{", "}");
			userJSON.add("\"id\": "+user.getId()).add("\"phoneNumber\": \""+user.getPhoneNumber()+"\"");
			joiner.add(userJSON.toString());
		}
		return joiner.toString();
	}
}
