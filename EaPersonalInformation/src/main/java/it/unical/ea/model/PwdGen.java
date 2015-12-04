package it.unical.ea.model;

import java.security.SecureRandom;

public class PwdGen {
	private String password;
	SecureRandom random = new SecureRandom();
	StringBuffer buffer = new StringBuffer();

	public PwdGen() {
		this.onlyletters();
	}

	public void onlyletters() {
		int length = (int) (Math.random()*2+47);
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabet = allowedCharacters.toCharArray();
		//System.out.println("password length " + length);

		for (int i = 0; i < length; i++) {
			buffer.append(alphabet[random.nextInt(alphabet.length)]);
		}

		password = buffer.toString();
	}

	@Override
	public String toString() {
		return "password: " + password;
	}

}
