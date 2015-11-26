package br.usp.poli.pcs.capstoneProject.fieldValidators;

public class CPFValidator implements IValidator {
	static String CPF_REGEX = "^([0-9]{3}.){2}([0-9]{3}-)([0-9]{2})$";
	public boolean validates(String value) {	
		return value.matches(CPF_REGEX);
	}
}
