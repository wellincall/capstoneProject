package br.usp.poli.pcs.capstoneProject.helpers;

public class GetContactsHelper {
	public String[] call(String userContacts) {
		return userContacts.replaceAll("[^0-9,+]", "").split(",");
	}
}
