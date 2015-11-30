package br.usp.poli.pcs.capstoneProject.jsonHelpers;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.StringJoiner;
import br.usp.poli.pcs.capstoneProject.models.TransferIntention;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserByIdService;
import br.usp.poli.pcs.capstoneProject.models.User;

public class TransferIntentionsListToJson {
	
	private static String DATE_FORMAT = "dd/MM/yyyy hh:mm:ss";
	
	public String call(List<TransferIntention> transferIntentions, boolean userIsSender) {
		StringJoiner arrayJSON = new StringJoiner(", ", "[", "]");
		for (TransferIntention transfer : transferIntentions) {
			arrayJSON.add(transferToJson(transfer, userIsSender));
		}
		return arrayJSON.toString();
	}
	
	private String transferToJson(TransferIntention transfer, boolean userIsSender) {
		StringJoiner objectJSON = new StringJoiner(", ", "{", "}");
		objectJSON.add("\"id\": "+transfer.getId()).add("\"amount\": "+transfer.getValue()).add("\"status\": \""+transfer.statusToHuman()+"\"");
		if (userIsSender) {
			User recipient = (new GetUserByIdService()).call(transfer.getRecipientId());
			objectJSON.add("\"recipient\": \"" + recipient.getName()+"\"")
						.add("\"sentOn\": \"" + formatDate(transfer.getCreationDate())+"\"");
		} else {
			User sender = (new GetUserByIdService()).call(transfer.getSenderId());
			objectJSON.add("\"sender\": \"" + sender.getName()+"\"")
						.add("\"recievedOn\": \""+formatDate(transfer.getCreationDate())+"\"");
		}
		return objectJSON.toString();
	}
	
	private String formatDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		return dateFormat.format(date);
	}
}
