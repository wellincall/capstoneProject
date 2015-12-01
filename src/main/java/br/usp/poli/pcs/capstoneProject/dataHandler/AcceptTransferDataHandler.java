package br.usp.poli.pcs.capstoneProject.dataHandler;

import java.util.Map;
import java.util.HashMap;

import spark.Request;

import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserBankAccountByIdService;
import br.usp.poli.pcs.capstoneProject.database.services.GetBankIdFromTokenService;
import br.usp.poli.pcs.capstoneProject.database.services.GetTransferIntentionByIdService;

public class AcceptTransferDataHandler implements IDataHandlerService {
	public Map<String, Object> call(Request request) {
		int userId = request.session().attribute("user-id");
		Map<String, Object> transferData = new HashMap<String, Object>();
		int accountId = Integer.valueOf(request.queryParams("recipient-account-id"));
		int transferId = Integer.valueOf(request.queryParams("transfer-id"));
		UserBankAccount account = (new GetUserBankAccountByIdService()).call(accountId, userId);
		transferData.put("bankId", (new GetBankIdFromTokenService()).call(account.getAccountToken()));
		transferData.put("accountToken", account.getAccountToken());
		transferData.put("userId", userId);
		transferData.put("amount", (new GetTransferIntentionByIdService()).call(transferId, userId).getValue());
		transferData.put("transferId", Integer.valueOf(request.queryParams("transfer-id")));
		return transferData;
	}
}
