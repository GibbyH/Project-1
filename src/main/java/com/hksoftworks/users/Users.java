package com.hksoftworks.users;

import java.io.Serializable;

public class Users implements Serializable {

	private int userId;
	private String lastName;
	private String firstName;
	private String email;
	private int managerId;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int userId, String lastName, String firstName, String email, int managerId) {
		super();
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.managerId = managerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", managerId=" + managerId + "]";
	}
	
	
}
