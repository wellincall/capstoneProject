package br.usp.poli.pcs.capstoneProject.models;

import java.util.Calendar;
import java.util.Date;
import br.usp.poli.pcs.capstoneProject.models.User;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserByIdService;
import br.usp.poli.pcs.capstoneProject.helpers.DateFormatter;

public class TransferIntention {
	public static final int CREATED = 0;
	public static final int DECLINED = 1;
	public static final int ACCEPTED = 2;
	public static final int VOIDED = 3;
	public static final int CONSOLIDATED = 4;
		
	private int id;
	private double value;
	private int recipientId;
	private int senderId;
	private int status;
	private Withdraw withdraw;
	private Deposit deposit;
	private Date creationDate;
	private User recipient;
	private User sender;
	public int getId() {
		return id;
	}
	public double getValue() {
		return value;
	}
	public int getRecipientId() {
		return recipientId;
	}
	public int getSenderId() {
		return senderId;
	}
	public int getStatus() {
		return status;
	}
	public Withdraw getWithdraw() {
		return withdraw;
	}
	public Deposit getDeposit() {
		return deposit;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	
	public String statusToHuman() {
		switch (status) {
		case CREATED: 
			return "pending";
		case DECLINED:
			return "declined";
		case ACCEPTED:
			return "accepted";
		case VOIDED:
			return "voided";
		case CONSOLIDATED: 
			return "consolidated";
		default:
			return "invalid";
		}
	}
	
	public boolean isCreated() {
		return status == CREATED;
	}
	
	public boolean isDeclined() {
		return status == DECLINED;
	}
	
	public boolean isAccepted() {
		return status == ACCEPTED;
	}
	
	public boolean isVoided() {
		return status == VOIDED;
	}
	
	public boolean isConsolidated() {
		return status == CONSOLIDATED;
	}
	
	public String getRecipientName() {
		if (recipient == null) {
			recipient = (new GetUserByIdService()).call(recipientId);
		}
		return recipient.getName();
	}
	
	public String getSenderName() {
		if (sender == null) {
			sender = (new GetUserByIdService()).call(senderId);
		}
		return sender.getName();
	}
	
	public String getRecipientPhoneNumber() {
		if (recipient == null) {
			recipient = (new GetUserByIdService()).call(recipientId);
		}
		return recipient.getPhoneNumber();
	}
	
	public String getSenderPhoneNumber() {
		if (sender == null) {
			sender = (new GetUserByIdService()).call(senderId);
		}
		return sender.getPhoneNumber();
	}
	
	public boolean canBeAccepted() {
		return status == CREATED;
	}
	
	public boolean canBeDeclined() {
		return status == CREATED;
	}
	
	public boolean canBeConsolidated() {
		return status == ACCEPTED;
	}
	
	public boolean canBeVoided() {
		return (status == ACCEPTED || status == CREATED) && allowedLimitToBeVoided();
	}
	
	public boolean canChangeStatus() {
		return status == ACCEPTED || status == CREATED;
	}
	
	public String creationDateInString() {
		return (new DateFormatter()).call(creationDate);
	}
	
	public boolean hasValidStatus() {
		return status == ACCEPTED || status == DECLINED || status == CREATED || status == VOIDED || status == CONSOLIDATED;
	}
	
	private boolean allowedLimitToBeVoided () {
		Calendar dateLimit = Calendar.getInstance();
		dateLimit.add(Calendar.HOUR_OF_DAY, -8);
		return dateLimit.getTime().compareTo(creationDate) < 0;
	}
	
}
