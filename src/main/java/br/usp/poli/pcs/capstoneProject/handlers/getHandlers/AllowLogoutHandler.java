package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import java.util.Map;
import java.util.HashMap;

import spark.Request;
import spark.Response;

public class AllowLogoutHandler extends DefaultGetHandler {
	public AllowLogoutHandler(Request request, Response response) {
		super(request, response);
		filePath = "allowLogout.ftl";
	}
	
	public Map<String, Object> process() {
		return new HashMap<String, Object>();
	}
}
