package it.unical.ea.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import it.unical.ea.validator.*;

//@FieldMatch.List({
//    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
//    @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
//})
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="email", nullable=false, length=50)
	@Size(max=50)
	@Email()
	@NotEmpty()
	private String email;
	//@Unique(service = UserService.class, fieldName = "email", message = "Email already exists!!!")
	
	@Size(max=50)
	@Email()
	@NotEmpty()
	private String confirmEmail;
	
	@Column(name="firstname", nullable=false, length=20)
	@Size(min=2, max=30)
	private String firstname;
	
	@Column(name="lastname", nullable=false, length=20)
	@Size(min=2, max=30)
	private String lastname;
	
	@Column(name="password", nullable=false, length=50)
	@Size(min = 6, max = 64)
	private String password;
	
	@Size(min = 6, max = 64)
	private String confirmPassword;

	@Column(name="phonenumber", length=20)
	@Size(min=4, max=20)
	private String phonenumber;
	
	@Column(name="gender", nullable=false, length=5)
	@Size(max=6)
	private String gender;
	
	@Column(name="dateOfBirth", nullable=false)
	@Temporal(TemporalType.DATE)
	@NotNull(message="The date of birth must be set")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past()	
	private Date dateOfBirth;
	
	//@CreditCardNumber
	@Column(name="creditcard", length=20)
	@Size(min=4, max=20)
	private String creditcard;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Account> accounts;

	public User() {
		this.id = 0;
		this.email = "";
		this.confirmEmail = "";
		this.firstname = "";
		this.lastname = "";
		this.password = "";
		this.confirmPassword = "";
		this.phonenumber = "";
		this.gender = "";
		this.dateOfBirth = null;
		this.creditcard = "";
		this.accounts = new ArrayList<Account>();
	}

	public User(Integer id, String email, String confirmEmail, String firstname, String lastname, String password, String confirmPassword,
			String phonenumber, String gender, Date dateOfBirth, String creditcard) {
		this.id = id;
		this.email = email;
		this.confirmEmail = confirmEmail;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.creditcard = creditcard;
		this.accounts = new ArrayList<Account>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	
	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return email;
	}
	
}