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
			if (!(boolean) request.session().attribute("is-verified")) {
				response.redirect("/not-verified");
			}
		});
		
		before("/verify-account", (request, response) -> {
			if (request.session().attribute("user-id") == null) {
				response.redirect("/not-authenticated");
			}
		});
		
		before("/verify-my-account", (request, response) -> {
			if (request.session().attribute("user-id") == null) {
				response.redirect("/not-authenticated");
			}
		});
		
		get("/", (request, response) -> {
			return (new HomePageHandler(request, response)).call();
		});
		
		get("/not-authenticated", (request, response) -> {
			response.status(403);
			response.type("application/json");
			return "{status: 2, message: \"User not authenticated\"}"; 
		});
		
		get("/not-verified", (request, response) -> {
			response.status(403);
			response.type("application/json");
			return "{status: 2, message: \"User not verified\"}"; 
		});
		
		get("/verify-account", (request, response) -> {
			return (new VerifyAccountDisplayHandler(request, response)).call(); 
		});
		
		post("/verify-my-account", (request, response) -> {
			return (new VerifyAccountHandler(request, response)).call();
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
			if (request.session().attribute("user-id") != null) {
				request.session().removeAttribute("user-id");
			}
			response.redirect("/login");
			return "";
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
		
		post("/user/register-bank-account", (request, response) -> {
			return (new AssociateUserAccountHandler(request, response)).call();
		});
		
		get("/user/ask-accounts", (request, response) -> {
			return (new AskAccountsHandler(request, response)).call();
		});
		
		post("/user/accounts", (request, response) -> {
			return (new GetUserAccountsHandler(request, response)).call();
		});
		
		get("/user/list-accounts", (request, response) -> {
			return (new ListUserAccountsHandler(request, response)).call();
		});
		
		post("/user/remove-account", (request, response) -> {
			return (new RemoveUserAccountHandler(request, response)).call();
		});
		
		get("/user/new-transfer", (request, response) -> {
			return (new NewTransferDisplayHandler(request, response)).call();
		});
		
		post("/user/new-transfer-intention", (request, response) -> {
			return (new NewTransferIntentionHandler(request, response)).call();
		});
		
		get("/user/ask-transfer-intentions-list", (request, response) -> {
			return (new ListTransferIntentionsDisplayHandler(request, response)).call();
		});
		
		post("/user/list-transfer-intentions", (request, response) -> {
			return (new ListTransferIntentionsHandler(request, response)).call();
		});
		
		get("/user/transfer-intentions-menu", (request, response) -> {
			return (new MenuTransferIntentionsDisplayHandler(request, response)).call();
		});
		
		post("/user/void-transfer", (request, response) -> {
			return (new VoidTransferHandler(request, response)).call();
		});
		
		post("/user/decline-transfer", (request, response) -> {
			return (new DeclineTransferHandler(request, response)).call();
		});
		
		get("/user/accept-transfer-page", (request, response) -> {
			return (new AcceptTransferDisplayHandler(request, response)).call();
		});
		
		post("/user/accept-transfer", (request, response) -> {
			return (new AcceptTransferHandler(request, response)).call();
		});
		
		get("/ask-to-consolidate", (request, response) -> {
			return (new ConsolidateTransfersDisplayHandler(request, response)).call();
		});
		
		post("/consolidate", (request, response) -> {
			return (new ConsolidateTransfersHandler(request, response)).call();
		});
	}
}
