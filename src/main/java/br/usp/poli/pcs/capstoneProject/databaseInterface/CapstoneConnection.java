package br.usp.poli.pcs.capstoneProject.databaseInterface;
import org.sql2o.Sql2o;

public class CapstoneConnection {
	private Sql2o databaseConnection;
	
	public CapstoneConnection() {
		databaseConnection = new Sql2o("jdbc:postgresql://localhost:5432/capstoneProject", "postgres", "postgres");
	}
	
	public Sql2o getConnection() {
		return databaseConnection;
	}
}
