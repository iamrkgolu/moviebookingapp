package com.moviebookingapp.dto;

public class User {
	private String loginId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;	
	private String contactNumber;
	private String roles;
	private String secretQuestion;
	private String answer;
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getLoginId() {
		return loginId;
	}
	public String setLoginId(String loginId) {
		this.loginId = loginId;
		return loginId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String setFirstName(String firstName) {
		this.firstName = firstName;
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String setLastName(String lastName) {
		this.lastName = lastName;
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String setEmail(String email) {
		this.email = email;
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		this.password = password;
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public String setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return confirmPassword;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String setContactNumber(String contactNumber) {
		this.contactNumber=contactNumber;
		return contactNumber;
	}
	
	

}
