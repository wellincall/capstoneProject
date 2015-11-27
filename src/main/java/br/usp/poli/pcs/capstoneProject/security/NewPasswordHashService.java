package br.usp.poli.pcs.capstoneProject.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class NewPasswordHashService extends PasswordHashService {
	
	protected String hashPassword(String password) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			String salt = generateSalt();
			String secret = salt + password;
			messageDigest.update(secret.getBytes());
			return salt + bytesToString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	protected String generateSalt() {
		StringBuffer salt = new StringBuffer();
		for(int i = 0; i <= 1; i++) {
			Random numberGenerator = new SecureRandom();
			salt.append(CHARS.charAt(numberGenerator.nextInt(CHARS.length())));
		}
		return salt.toString();
	}
}
