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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "connection_1")
public class Connection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "connection_id")
	private int connectionId;
	@Column(name = "name")
	private String name;
	@Column(name = "user_from_id")
	private int userFromId;
	@Column(name = "user_to_id")
	private int userToId;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	@JoinColumn(name = "connection_id")
	private List<Transaction> transactions = new ArrayList<>();
	
	
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserFromId() {
		return userFromId;
	}
	public void setUserFromId(int userFromId) {
		this.userFromId = userFromId;
	}
	public int getUserToId() {
		return userToId;
	}
	public void setUserToId(int userToId) {
		this.userToId = userToId;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
