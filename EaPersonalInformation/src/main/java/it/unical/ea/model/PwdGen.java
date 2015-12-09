package it.unical.ea.model;

import java.security.SecureRandom;

public class PwdGen {
	private String password;
	SecureRandom random = new SecureRandom();

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

		password = buffer.toString();
		return password;
	}
	
	public String onlylettersandnumbers() {
		StringBuffer buffern = new StringBuffer();
		int lengthn = (int) ((Math.random()*50)+4);
		String allowedCharactersn = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabetn = allowedCharactersn.toCharArray();

		for (int i = 0; i < lengthn; i++) {
			buffern.append(alphabetn[random.nextInt(alphabetn.length)]);
		}

		password = buffern.toString();
		return password;
	}
	
	public String LetNumSpecialChar() {
		StringBuffer buffern = new StringBuffer();
		int lengthn = (int) ((Math.random()*50)+4);
		String allowedCharactersn = "~!@#$%^&*()`_-+=/.,><;][{}1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabetn = allowedCharactersn.toCharArray();

		for (int i = 0; i < lengthn; i++) {
			buffern.append(alphabetn[random.nextInt(alphabetn.length)]);
		}

		password = buffern.toString();
		return password;
	}
	@Override
	public String toString() {
		return "password: " + password;
	}

}
