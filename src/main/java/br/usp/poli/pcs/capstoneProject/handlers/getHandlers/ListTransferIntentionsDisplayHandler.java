package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;

public class ListTransferIntentionsDisplayHandler extends DefaultGetHandler {
	
	public ListTransferIntentionsDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "askTransferIntentionsList.ftl";
	}
	
	public Map<String, Object> process() {
		return null;
	}
}
