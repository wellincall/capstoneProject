package br.usp.poli.pcs.capstoneProject.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordHashService {
	private static String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+-=";
	
	public static String call(String password) {
		return hashPassword(password);
	}
	
	private static String hashPassword(String password) {
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
	
	private static String bytesToString(byte[] bytes) {
        StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
		return hexString.toString();
	}
	
	private static String generateSalt() {
		StringBuffer salt = new StringBuffer();
		for(int i = 0; i <= 1; i++) {
			Random numberGenerator = new SecureRandom();
			salt.append(CHARS.charAt(numberGenerator.nextInt(CHARS.length())));
		}
		return salt.toString();
	}
}
