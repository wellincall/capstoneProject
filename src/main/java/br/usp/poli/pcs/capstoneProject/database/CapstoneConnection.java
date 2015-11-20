package br.usp.poli.pcs.capstoneProject.database;
import org.sql2o.Sql2o;

public class CapstoneConnection {
	private Sql2o databaseConnection;
	
	public CapstoneConnection() {
		databaseConnection = new Sql2o("jdbc:postgresql//localhost:5432/capstoneproject", "postgres", "");
	}
}
