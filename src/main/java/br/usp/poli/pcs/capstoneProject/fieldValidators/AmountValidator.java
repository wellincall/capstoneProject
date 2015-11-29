package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class AmountValidator implements IValidator {
	public boolean validates(String value) {
		return Double.valueOf(value) > 0;
	}
}
