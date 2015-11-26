package br.usp.poli.pcs.capstoneProject.handlers;

import java.util.Map;
import java.util.HashMap;
import spark.Request;
import spark.Response;

public class PageHandler extends DefaultHandler {
	
	public PageHandler(Request request, Response response) {
		super(request, response);
		filePath = "page.ftl";
	}
	
	protected Map<String, Object> process() {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("message", "This is my first page");
		return attributes;
		
	}
	
}
