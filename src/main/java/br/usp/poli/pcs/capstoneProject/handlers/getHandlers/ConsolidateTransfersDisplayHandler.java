package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;

public class ConsolidateTransfersDisplayHandler extends DefaultGetHandler {

	public ConsolidateTransfersDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "askToConsolidate.ftl";
	}
	
	public Map<String, Object> process() {
		return null;
	}
	
}
