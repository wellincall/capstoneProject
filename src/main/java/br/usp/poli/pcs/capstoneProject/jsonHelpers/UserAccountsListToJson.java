package br.usp.poli.pcs.capstoneProject.jsonHelpers;

import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;
import br.usp.poli.pcs.capstoneProject.models.Bank;
import br.usp.poli.pcs.capstoneProject.database.services.GetBankIdFromTokenService;
import br.usp.poli.pcs.capstoneProject.database.services.GetBankByIdService;
import java.util.List;
import java.util.StringJoiner;

public class UserAccountsListToJson {
	public String call(List<UserBankAccount> userAccounts) {
		StringJoiner jsonList = new StringJoiner(",", "[", "]");
		for (UserBankAccount account : userAccounts) {
			StringJoiner jsonObject = new StringJoiner(", ", "{", "}");
			int bankId = (new GetBankIdFromTokenService()).call(account.getAccountToken());
			Bank bank = (new GetBankByIdService()).call(bankId);
			jsonObject.add("\"id\": "+account.getId()).add("\"bankName\": \""+bank.getName()+"\"").add("\"token\": \""+account.getAccountToken()+"\"");
			jsonList.add(jsonObject.toString());
		}
		
		return jsonList.toString();
	}
}
