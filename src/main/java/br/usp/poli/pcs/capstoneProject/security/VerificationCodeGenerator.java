package br.usp.poli.pcs.capstoneProject.security;

import java.security.SecureRandom;
import java.util.Random;

public class VerificationCodeGenerator {
	private static String ALLOWED_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	public String call() {
		StringBuffer token = new StringBuffer();
		for(int i = 0; i < 6; i++) {
			Random numberGenerator = new SecureRandom();
			token.append(ALLOWED_CHARS.charAt(numberGenerator.nextInt(ALLOWED_CHARS.length())));
		}
		return token.toString();
	}
}
