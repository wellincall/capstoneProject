package br.usp.poli.pcs.capstoneProject.fieldValidators;
import java.util.List;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserBankAccountIdsService;

public class UserBankAccountForeignKeyValidator implements IForeignKeyValidator {
	
	public boolean validates(int dummy) {
		return false;
	}
	
	public boolean validates(int userBankAccountId, int userId) {
		List<Integer> accountsIds = (new GetUserBankAccountIdsService()).call(userId);
		return accountsIds.contains(userBankAccountId);
	}
}
