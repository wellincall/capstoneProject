package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import java.util.List;
import br.usp.poli.pcs.capstoneProject.models.UserBankAccount;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserAccountsService;

public class GetUserAccountsHandler extends DefaultPostHandler {
	public GetUserAccountsHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		List<UserBankAccount> userBankAccounts = (new GetUserAccountsService()).call(request.session().attribute("user-id"));
		return "";
	}
}
