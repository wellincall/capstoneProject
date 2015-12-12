package br.usp.poli.pcs.capstoneProject.jsonHelpers;

import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.helpers.DateFormatter;
import java.util.StringJoiner;

public class UserToJSon {
	public String call(User user) {
		StringJoiner json = new StringJoiner(", ", "{", "}");
		json.add("\"name\": " + user.getName());
		json.add("\"email\": " + user.getEmail());
		json.add("\"cpf\": " + user.getCpf());
		json.add("\"birtdayDate\": " + (new DateFormatter()).call(user.getBirthdayDate()));
		json.add("\"phoneNumber\": " + user.getPhoneNumber());
		return json.toString();
	}
}
