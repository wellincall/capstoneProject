package br.usp.poli.pcs.capstoneProject.handlers.postHandlers;

import br.usp.poli.pcs.capstoneProject.handlers.DefaultHandler;
import spark.Request;
import spark.Response;


public abstract class DefaultPostHandler extends DefaultHandler{
	
	public DefaultPostHandler(Request request, Response response) {
		super(request, response);
	}
	
	public final String call() {
		init();
		return process();	
	}
	
	public final void init() {
		response.type("application/json");
	}
	
	public abstract String process();
}
