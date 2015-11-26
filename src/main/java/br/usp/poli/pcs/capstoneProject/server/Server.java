package br.usp.poli.pcs.capstoneProject.server;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import spark.ModelAndView;

import java.util.Map;
import java.util.HashMap;

import br.usp.poli.pcs.capstoneProject.database.CapstoneConnection;
import br.usp.poli.pcs.capstoneProject.handlers.PageHandler;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;

public class Server {
	public static void main(String[] args) {
		staticFileLocation("/public");
		get("/hello", (request, response) -> {
			return "it works";
		});
		
		get("/page", (request, response) -> {
			return (new PageHandler(request, response)).call();			
		});
	}
}
