package com.hksoftworks.beans;

public class Employee {

	private int empId;
	private String lastName;
	private String firstName;
	private String email;
	private String pass;
	private int managerId;
	
	public Employee(int empId, String lastName, String firstName, String email, String pass, int managerId) {
		super();
		this.empId = empId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.pass = pass;
		this.managerId = managerId;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
