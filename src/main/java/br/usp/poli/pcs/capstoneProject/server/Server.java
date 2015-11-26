package br.usp.poli.pcs.capstoneProject.server;

import static spark.Spark.*;
import br.usp.poli.pcs.capstoneProject.handlers.NewUserHandler;

public class Server {
	static int PORT = 3000;
	static String STATIC_FILES_LOCATION = "/public";
	public static void main(String[] args) {
		port(PORT);
		staticFileLocation(STATIC_FILES_LOCATION);
		
		get("/hello", (request, response) -> {
			return "it works";
		});
		
		get("/page", (request, response) -> {
			return (new NewUserHandler(request, response)).call();			
		});
	}
}
