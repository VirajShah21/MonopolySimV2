package org.virajshah.monopoly.core;

public class Player {
	private String name;
	private int balance;

	public Player(String name) {
		this.name = name;
		this.balance = 1500;
	}

	public void transaction(int amount, Player other) {
		// TODO: Implement
	}

	public boolean transaction(int amount) {
		balance += amount;
		return true;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
