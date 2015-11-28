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
		
		before("/user/*", (request, response) -> {
			if (request.session().attribute("user-id") == null) {
				response.redirect("/not-authenticated");
			}
		});
		
		get("/not-authenticated", (request, response) -> {
			response.status(403);
			response.type("application/json");
			return "{status: 2, message: \"User not authenticated\"}"; 
		});
		
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
			if(request.session().attribute("user-id") != null) {
				response.redirect("/allow-logout");
				return "";
			} else {
				return (new LoginDisplayHandler(request, response)).call();
			}
		});
		
		post("/authenticate", (request, response) -> {
			return (new AuthenticationHandler(request, response)).call();
		});
		
		get("/allow-logout", (request, response) -> {
			if (request.session().attribute("user-id") == null) {
				response.redirect("/login");
				return "";
			} else {
				return (new AllowLogoutHandler(request, response)).call();
			}
		});
		
		post("/deauthenticate", (request, response) -> {
			if (request.session().attribute("user-id") == null) {
				response.redirect("/login");
				return "";
			} else {
				request.session().removeAttribute("user-id");
				response.redirect("/login");
				return "";
			}
		});
		
		get("/user/reset-password", (request, response) -> {
			return (new NewPasswordDisplayHandler(request, response)).call();
		});
		
		post("/user/update-password", (request, response) -> {
			return (new UpdatePasswordHandler(request, response)).call();
		});
		
		get("/user/import-contacts", (request, response) -> {
			return (new ImportContactsDisplayHandler(request, response)).call();
		});
		
		post("/user/import-contacts", (request, response) -> {
			return (new ImportContactsHandler(request, response)).call();
		});
		
		get("/user/ask-banks", (request, response) -> {
			return (new AskBanksHandler(request, response)).call();
		});
		
		post("/user/banks", (request, response) -> {
			return (new GetBanksHandler(request, response)).call();
		});
		
		get("/user/new-account", (request, response) -> {
			return (new NewUserBankAccountDisplayHandler(request, response)).call();
		});
	}
}
