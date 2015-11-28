package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;

public class AskBanksHandler extends DefaultGetHandler {
	public AskBanksHandler(Request request, Response response) {
		super(request, response);
		filePath = "askBanks.ftl";
	}
	
	public Map<String, Object> process() {
		return null;
	}

}
