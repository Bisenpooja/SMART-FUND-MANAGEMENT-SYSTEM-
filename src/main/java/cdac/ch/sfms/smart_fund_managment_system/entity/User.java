package cdac.ch.sfms.smart_fund_managment_system.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id; 
	 
	
	 private String username;
	 
	 private String email;
	 
	 private String password;
	 
	 private String phonenumber;
	 
	 private String role;
	 
	 public User() {
		 
	 }

	public User(String username, String email, String password, String phonenumber, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

	
	

