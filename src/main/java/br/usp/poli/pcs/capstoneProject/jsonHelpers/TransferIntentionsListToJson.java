package br.usp.poli.pcs.capstoneProject.jsonHelpers;

import java.util.List;
import java.util.StringJoiner;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;

public class TransferIntentionsListToJson {
	public String call(List<TransferIntention> transferIntentions) {
		StringJoiner arrayJSON = new StringJoiner(", ", "[", "]");
		for (TransferIntention transfer : transferIntentions) {
			StringJoiner objectJSON = new StringJoiner(", ", "{", "}");
			objectJSON.add("id: "+transfer.getId()).add("amount: "+transfer.getValue()).add("status: \""+transfer.statusToHuman()+"\"");
			arrayJSON.add(objectJSON.toString());
		}
		return arrayJSON.toString();
	}
}
