package com.maven.api.model;

/**
 * This class is the model of the Person Object
 * 
 * June 25, 2019
 * 
 * @author christian
 *
 */
public class Person {

	private int pid;
	private String firstname;
	private String lastname;
	private String email;

	public Person() {
		super();
	}

	public Person(int pid, String firstname, String lastname, String email) {
		super();
		this.pid = pid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return ("Person [pid=" + pid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]");
	}
	
	

}
