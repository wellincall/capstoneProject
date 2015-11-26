package br.usp.poli.pcs.capstoneProject.fieldValidators;

import java.util.List;
import br.usp.poli.pcs.capstoneProject.databaseImplementation.BankDAO;
import br.usp.poli.pcs.capstoneProject.databaseInterface.CapstoneConnection;

public class BankForeignKeyValidator implements IForeignKeyValidator{
	public boolean validates(int foreignKey) {
		CapstoneConnection db = new CapstoneConnection();
		BankDAO dao = new BankDAO();
		List<Integer> ids = dao.getBankIds(db.getConnection());
		return ids.contains(foreignKey);
	}
}
