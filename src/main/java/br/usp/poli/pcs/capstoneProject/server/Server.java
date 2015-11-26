package br.usp.poli.pcs.capstoneProject.server;

import static spark.Spark.*;
import br.usp.poli.pcs.capstoneProject.handlers.*;
import br.usp.poli.pcs.capstoneProject.handlers.getHandlers.NewBankHandler;
import br.usp.poli.pcs.capstoneProject.handlers.getHandlers.NewUserHandler;
import br.usp.poli.pcs.capstoneProject.handlers.postHandlers.RegisterUserHandler;

public class Server {
	static int PORT = 3000;
	static String STATIC_FILES_LOCATION = "/public";
	public static void main(String[] args) {
		port(PORT);
		staticFileLocation(STATIC_FILES_LOCATION);
		
		get("/new-user", (request, response) -> {
			return (new NewUserHandler(request, response)).call();			
		});
		
		post("/register-user", (request, response) -> {
			return (new RegisterUserHandler(request, response).call());
		});
		
		get("/new-bank", (request, response) -> {
			return (new NewBankHandler(request, response)).call();
		});
		
		post("/register-bank", (request, response) -> {
			 
		});
		
		
	}
}
