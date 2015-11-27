package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Response;
import spark.Request;
import br.usp.poli.pcs.capstoneProject.forms.Form;
import br.usp.poli.pcs.capstoneProject.forms.NewBankAccountForm;
import br.usp.poli.pcs.capstoneProject.helpers.GetBanksService;

public class RegisterBankAccountHandler extends DefaultPostHandler {
	public RegisterBankAccountHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		Form form = new NewBankAccountForm((new GetBanksService()).call());
		if (form.isValid(request)) {
			return "{Success: \"Check dB\" }";
		} else {
			return "{Error: \"Motherfocker\"}";
		}
	}
}
