package server;
import static spark.Spark.*;

public class Server {
	public static void main(String[] args) {
		get("/hello", (request, response) -> "it works");
	}
}
