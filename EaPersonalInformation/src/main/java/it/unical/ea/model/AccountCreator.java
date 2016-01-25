package it.unical.ea.model;

import javax.validation.Valid;

public class AccountCreator {
	
	@Valid
	private Account account;
	
	private String word1;
	private String word2;
	private Integer passType;	

	public AccountCreator() {
		this.account = new Account();
		this.word1 = "";
		this.word2 = "";
		this.passType = 0;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public Integer getPassType() {
		return passType;
	}

	public void setPassType(Integer passType) {
		this.passType = passType;
	}
	
}
