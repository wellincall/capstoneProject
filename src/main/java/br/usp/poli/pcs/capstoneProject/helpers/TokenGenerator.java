package br.usp.poli.pcs.capstoneProject.helpers;


import java.util.Map;
import br.usp.poli.pcs.capstoneProject.security.PasswordHashService;;

public class TokenGenerator {
	public static String call(Map<String, Object> accountInfo) {
		StringBuffer buffer = new StringBuffer();
		for (String key : accountInfo.keySet()) {
			buffer.append(String.valueOf(accountInfo.get(key)));
		}
		return PasswordHashService.call(buffer.toString()).substring(2);
	}
}
