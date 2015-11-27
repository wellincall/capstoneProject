package br.usp.poli.pcs.capstoneProject.database.services;

import br.usp.poli.pcs.capstoneProject.database.interfaces.CapstoneConnection;

public abstract class DatabaseService {
	protected CapstoneConnection db;
	
	public DatabaseService() {
		db = new CapstoneConnection();
	}
}
