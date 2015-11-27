package br.usp.poli.pcs.capstoneProject.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordHashService {
	protected  String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+-=";
	
	public String call(String password) {
		return hashPassword(password);
	}
	
	protected String hashPassword(String password) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes());
			return bytesToString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	protected  String bytesToString(byte[] bytes) {
        StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
		return hexString.toString();
	}
	
	
}
