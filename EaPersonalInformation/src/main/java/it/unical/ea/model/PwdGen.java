package it.unical.ea.model;

import java.security.SecureRandom;

public class PwdGen {
	private String password;
	SecureRandom random = new SecureRandom();

	public PwdGen() {
	}

	public String onlyletters() {
		StringBuffer buffer = new StringBuffer();
		int length = (int) ((Math.random()*46)+4);
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabet = allowedCharacters.toCharArray();

		for (int i = 0; i < length; i++) {
			buffer.append(alphabet[random.nextInt(alphabet.length)]);
		}

		password = buffer.toString();
		return password;
	}

	@Override
	public String toString() {
		return "password: " + password;
	}

}
