package com.api.models.response;

public class UserProfileResponse {
	
	protected int id;
	protected String username ; 
	protected String email;  
	protected String firstName ; 
	protected String lastName;
	protected int mobileNumber ;
	
	public UserProfileResponse() {
		
	}
	
	public UserProfileResponse(int id, String username, String email, String firstName, String lastName, int mobileNumber) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", username=" + username + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
	

}
