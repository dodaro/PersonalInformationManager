package it.unical.ea.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="accountname", unique = true, nullable=false, length=20)
	@Size(min=2, max=30)
	private String accountname;

	@Column(name="type", nullable=false, length=20)
	private String type;
	
	@Column(name="username", nullable=false, length=20)
	@Size(min=2, max=30)
	private String username;
	
	@Column(name="password", nullable=false, length=20)
	@Size(min = 6, max = 64)
	private String password;
	
	private String passwordGen;
	
	@Column(name="notes")
	@Size(max = 512)
	private String notes;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	public Account(Integer id, String type, String username, String password, String passwordGen, User user) {
		this.id = id;
		this.type = type;
		this.username = username;
		this.password = password;
		this.passwordGen = passwordGen;
		this.user = user;
	}

	public Account() {
		this.id = 0;
		this.type = "";
		this.username = "";
		this.password = "";
		this.passwordGen = "";
		this.user = null;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPasswordGen() {
		return passwordGen;
	}

	public void setPasswordGen(String passwordGen) {
		this.passwordGen = passwordGen;
	}
	
	@Override
	public String toString() {
		return user + ", " + accountname + ", " + type + ", " + username + ", " + password;
	}
	
	
}
