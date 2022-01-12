package com.paymybuddy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_1")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "connection_1", joinColumns = @JoinColumn(name = "user_from_id"), inverseJoinColumns = @JoinColumn(name = "user_to_id"))
	@JsonIgnore
	private List<User> usersTo = new ArrayList<>();

	
	@ManyToMany(
			mappedBy = "usersTo",
			cascade = CascadeType.ALL
			)
	@JsonIgnore
	private List<User> usersFrom = new ArrayList<>();
	
	public List<User> getUsersFrom() {
		return usersFrom;
	}

	public void setUsersFrom(List<User> usersFrom) {
		this.usersFrom = usersFrom;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<User> getUsersTo() {
		return usersTo;
	}

	public void setUsersTo(List<User> usersTo) {
		this.usersTo = usersTo;
	}

	public User(){}
	
	public User(String _email,String _firstName,String _lastName,String _login, String _password ) {
		this.email = _email;
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.login = _login;
		this.password = _password;
	}
}
