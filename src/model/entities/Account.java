package model.entities;

import model.exceptions.DomainException;

public class Account {
	protected Integer number;
	protected String holder;
	protected Double balance;
	protected Double withdrawLimit;
		
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(Double amount) {
		if(amount<20) {
			throw new DomainException("Minimal deposit is $20");
		}
		balance += amount;
		System.out.println("New balance: "+balance);
	}
	public void withdraw(Double amount) {
		if(amount>balance) {
			throw new DomainException("Not enough funds.");
		}
		if(amount>withdrawLimit) {
			throw new DomainException("Exceeds the withdraw limit.");
		}
		balance -= amount;
		System.out.println("New balance: "+balance);
	}

	@Override
	public String toString() {
		return "Number: " + number + " - Holder: " + holder + " - Balance: " + balance + " - Withdraw limit: "
				+ withdrawLimit;
	}
	
}
