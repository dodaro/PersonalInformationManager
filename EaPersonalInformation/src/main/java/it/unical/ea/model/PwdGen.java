package it.unical.ea.model;

import java.security.SecureRandom;

public class PwdGen {
	private String password;
	private SecureRandom random = new SecureRandom();

	public PwdGen() {
	}

	public String onlyletters() {
		StringBuffer buffer = new StringBuffer();
		int length = (int) ((Math.random()*50)+4);
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabet = allowedCharacters.toCharArray();

		for (int i = 0; i < length; i++) {
			buffer.append(alphabet[random.nextInt(alphabet.length)]);
		}

		return buffer.toString();
	}
	
	public String onlylettersandnumbers() {
		StringBuffer buffer = new StringBuffer();
		int length = (int) ((Math.random()*50)+4);
		String allowedCharacters = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabet = allowedCharacters.toCharArray();

		for (int i = 0; i < length; i++) {
			buffer.append(alphabet[random.nextInt(alphabet.length)]);
		}

		return buffer.toString();
	}
	
	public String letNumSpecialChar() {
		StringBuffer buffern = new StringBuffer();
		int lengthn = (int) ((Math.random()*50)+4);
		String allowedCharactersn = "~!@#$%^&*()`_-+=/.,><;][{}1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabetn = allowedCharactersn.toCharArray();

		for (int i = 0; i < lengthn; i++) {
			buffern.append(alphabetn[random.nextInt(alphabetn.length)]);
		}

		return buffern.toString();
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "password: " + password;
	}

}
