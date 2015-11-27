package br.usp.poli.pcs.capstoneProject.server;

import static spark.Spark.*;
import br.usp.poli.pcs.capstoneProject.handlers.getHandlers.*;
import br.usp.poli.pcs.capstoneProject.handlers.postHandlers.*;

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
		
		get("/new-bank-account", (request, response) -> {
			return (new NewBankAccountHandler(request, response)).call();
		});
		
		post("/register-bank-account", (request, response) -> {
			return (new RegisterBankAccountHandler(request, response)).call();
		});
		
		get("/new-bank", (request, response) -> {
			return (new NewBankHandler(request, response)).call();
		});
		
		post("/register-bank", (request, response) -> {
			 return (new RegisterBankHandler(request, response)).call();
		});
		
		get("/login", (request, response) -> {
			return (new LoginDisplayHandler(request, response)).call();
		});
		
		post("/authenticate", (request, response) -> {
			return (new AuthenticationHandler(request, response)).call();
		});
		
		
	}
}
