package br.usp.poli.pcs.capstoneProject.server;

import static spark.Spark.*;
import br.usp.poli.pcs.capstoneProject.database.CapstoneConnection;

public class Server {
	public static void main(String[] args) {
		get("/hello", (request, response) -> {
			new CapstoneConnection();
			return "it works";
		});
	}
}
