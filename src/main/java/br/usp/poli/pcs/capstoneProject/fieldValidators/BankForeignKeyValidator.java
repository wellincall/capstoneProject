package br.usp.poli.pcs.capstoneProject.fieldValidators;

import java.util.List;

import br.usp.poli.pcs.capstoneProject.database.services.GetBankIdsService;

public class BankForeignKeyValidator implements IForeignKeyValidator{
	public boolean validates(int foreignKey) {
		List<Integer> ids = (new GetBankIdsService()).call();
		return ids.contains(foreignKey);
	}
}
