package br.usp.poli.pcs.capstoneProject.security;

import java.util.Random;
import java.security.SecureRandom;

public class TokenGeneratorService {
	private static String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+-=";
	public String call() {
		StringBuffer token = new StringBuffer();
		for(int i = 0; i < 64; i++) {
			Random numberGenerator = new SecureRandom();
			token.append(ALLOWED_CHARS.charAt(numberGenerator.nextInt(ALLOWED_CHARS.length())));
		}
		return token.toString();
	}
}
