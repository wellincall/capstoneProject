package br.usp.poli.pcs.capstoneProject.fieldValidators;

import java.util.List;
import br.usp.poli.pcs.capstoneProject.database.services.GetUserIdsService;

public class UserForeignKeyValidator implements IForeignKeyValidator {

	public boolean validates(int userForeignKey) {
		List<Integer> validIds = (new GetUserIdsService()).call();
		return validIds.contains(userForeignKey);
	}
	
}
