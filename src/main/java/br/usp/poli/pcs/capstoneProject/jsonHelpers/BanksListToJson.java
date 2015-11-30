package br.usp.poli.pcs.capstoneProject.jsonHelpers;

import java.util.List;
import java.util.StringJoiner;
import br.usp.poli.pcs.capstoneProject.models.Bank;

public class BanksListToJson {
	public String call(List<Bank> banks) {
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		for (Bank bank : banks) {
			StringJoiner bankJSON = new StringJoiner(", ", "{", "}");
			bankJSON.add("\"id\": "+bank.getId()).add("\"name\": \""+bank.getName()+"\"");
			joiner.add(bankJSON.toString());
		}
		return joiner.toString();
	}
}