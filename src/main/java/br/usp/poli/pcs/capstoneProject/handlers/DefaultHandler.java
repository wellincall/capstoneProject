package br.usp.poli.pcs.capstoneProject.handlers;

import spark.Request;
import spark.Response;

public abstract class DefaultHandler {
	
	protected Request request;
	protected Response response;
	
	public DefaultHandler(Request request, Response response) {
		this.request = request;
		this.response = response;
	}
	
	public abstract String call();
}
