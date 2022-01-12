package com.paymybuddy.model;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "opration_id")
	private int operationId;
	@Column(name = "credit")
	private Boolean credit;
	@Column(name = "amount")
	private BigDecimal amount;
	
	@ManyToOne(
			cascade = CascadeType.ALL
                                      )
	@JoinColumn(name="account_id")
	private Account account;
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getOperationId() {
		return operationId;
	}
	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}
	public Boolean getCredit() {
		return credit;
	}
	public void setCredit(Boolean credit) {
		this.credit = credit;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
