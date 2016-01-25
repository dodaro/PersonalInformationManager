package it.unical.ea.model;

import java.security.SecureRandom;

public class PwdGen {
	private SecureRandom random = new SecureRandom();
	private String pwdLett;
	private String pwdLettNum; 
	private String pwdLettNumSpec;
	private String pwdTwoWords;
	private String word1;
	private String word2;
	

	public PwdGen() {
		this.pwdLett = onlyletters();
		this.pwdLettNum = onlylettersandnumbers();
		this.pwdLettNumSpec = letNumSpecialChar();
		this.pwdTwoWords = twoWords(this.word1, this.word2);
		this.word1 = "";
		this.word2 = "";
	}

	private String onlyletters() {
		StringBuffer buffer = new StringBuffer();
		int length = (int) ((Math.random()*50)+4);
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabet = allowedCharacters.toCharArray();

		for (int i = 0; i < length; i++) {
			buffer.append(alphabet[random.nextInt(alphabet.length)]);
		}
		
		return buffer.toString();
	}
	
	private String onlylettersandnumbers() {
		StringBuffer buffer = new StringBuffer();
		int length = (int) ((Math.random()*50)+4);
		String allowedCharacters = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabet = allowedCharacters.toCharArray();

		for (int i = 0; i < length; i++) {
			buffer.append(alphabet[random.nextInt(alphabet.length)]);
		}
		
		return buffer.toString();
	}
	
	private String letNumSpecialChar() {
		StringBuffer buffer = new StringBuffer();
		int length = (int) ((Math.random()*50)+4);
		String allowedCharacters = "~!@#$%^&*()`_-+=/.,><;][{}1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphabet = allowedCharacters.toCharArray();

		for (int i = 0; i < length; i++) {
			buffer.append(alphabet[random.nextInt(alphabet.length)]);
		}
		
		
		return buffer.toString();
	}
	
	private String twoWords(String word1,String word2) {
		  StringBuffer buffer = new StringBuffer();
		  int length = (int) ((Math.random()*50)+4);
		  String allowedCharacters = "~!@#$%^&*()`_-+=/.,><;][{}1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		  char[] alphabet = allowedCharacters.toCharArray();

		  for (int i = 0; i < length; i++) {
		   buffer.append(alphabet[random.nextInt(alphabet.length)]);
		  }

		  return word1 + buffer.toString() + word2;
	}
	
	
	public String getPwdLett() {
		this.pwdLett = onlyletters();
		return pwdLett;
	}
	
	public String getPwdLettNum() {
		this.pwdLettNum = onlylettersandnumbers();
		return pwdLettNum;
	}

	public String getPwdLettNumSpec() {
		this.pwdLettNumSpec = letNumSpecialChar();
		return pwdLettNumSpec;
	}
	
	public String getPwdTwoWords() {
		this.pwdTwoWords = twoWords(this.word1, this.word2);
		return pwdTwoWords;
	}
	
	public void setPwdLett(String pwdLett) {
		this.pwdLett = pwdLett;
	}

	public void setPwdLettNum(String pwdLettNum) {
		this.pwdLettNum = pwdLettNum;
	}

	public void setPwdLettNumSpec(String pwdLettNumSpec) {
		this.pwdLettNumSpec = pwdLettNumSpec;
	}

	public void setPwdTwoWords(String pwdTwoWords) {
		this.pwdTwoWords = pwdTwoWords;
	}

	public String getWord1() {
		return word1;
	}

	public void setWord1(String word1) {
		this.word1 = word1;
	}

	public String getWord2() {
		return word2;
	}

	public void setWord2(String word2) {
		this.word2 = word2;
	}

	@Override
	public String toString() {
		return "password: " + pwdLett + pwdLettNum + pwdLettNumSpec + pwdTwoWords;
	}

}
