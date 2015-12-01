package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import spark.Request;
import spark.Response;

import br.usp.poli.pcs.capstoneProject.database.services.ConsolidateTransfersService;

public class ConsolidateTransfersHandler extends DefaultPostHandler {
	public ConsolidateTransfersHandler(Request request, Response response) {
		super(request, response);
	}
	
	public String process() {
		(new ConsolidateTransfersService()).call();
		return "{\"status\": \"Transfers marked as accepted and created before 8 hours ago were consolidated.\"}";
	}
}
