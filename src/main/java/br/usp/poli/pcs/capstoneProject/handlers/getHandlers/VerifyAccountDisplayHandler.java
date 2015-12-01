package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import spark.Request;
import spark.Response;
import java.util.Map;

public class VerifyAccountDisplayHandler extends DefaultGetHandler {
	
	public VerifyAccountDisplayHandler(Request request, Response response) {
		super(request, response);
		filePath = "verifyAccount.ftl";
	}
	
	public Map<String, Object> process() {
		return null;
	}
}
