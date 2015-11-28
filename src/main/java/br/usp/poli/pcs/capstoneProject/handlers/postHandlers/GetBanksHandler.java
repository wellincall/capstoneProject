package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import java.util.List;
import br.usp.poli.pcs.capstoneProject.database.services.GetBanksService;
import br.usp.poli.pcs.capstoneProject.jsonHelpers.BanksListToJson;
import br.usp.poli.pcs.capstoneProject.models.Bank;

public class GetBanksHandler extends DefaultPostHandler {
	public GetBanksHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		List<Bank> banks = (new GetBanksService()).call();
		return "{status: 0, message: \"All registered banks are in field banks\", banks: "+(new BanksListToJson()).call(banks)+" }";
	}
}
