package tn.esprit.spring.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

public class SignupRequest {
	private String username;

	private String email;

	private String password;
	
	private String FirstName;
	
	private String LastName;
	
	private String PhoneNumber;
	
	private String role;
	
	public SignupRequest()
	{
		
	}
	
	public SignupRequest(String username, String email, String password, String firstName, String lastName,
			String phoneNumber, Date dateOfBirth, String gender, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		FirstName = firstName;
		LastName = lastName;
		PhoneNumber = phoneNumber;
		DateOfBirth = dateOfBirth;
		Gender = gender;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private Date DateOfBirth;
	
	private String Gender;

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

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
}