package org.virajshah.monopoly.core;

import java.util.ArrayList;

import org.virajshah.monopoly.core.beans.TurnHistoryBean;
import org.virajshah.monopoly.tiles.PropertyTile;

public class Player {
	private String name;
	private int balance;
	private MonopolyGame game;
	private int position;
	private boolean prisoner;
	private ArrayList<TurnHistoryBean> turnHistory;
	private ArrayList<PropertyTile> properties;

	public Player(String name) {
		this.name = name;
		this.balance = 1500;
		position = 0;
		turnHistory = new ArrayList<>();
		properties = new ArrayList<>();
	}

	public void sendMoney(int amount, Player other) {
		// TODO: Implement
	}

	public boolean transaction(int amount) {
		balance += amount;
		return true;
	}

	/**
	 * @return the game
	 */
	public MonopolyGame getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(MonopolyGame game) {
		this.game = game;
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

	/**
	 * @return the turnHistory
	 */
	public ArrayList<TurnHistoryBean> getTurnHistory() {
		return turnHistory;
	}

	/**
	 * @param turnHistory the turnHistory to set
	 */
	public void setTurnHistory(ArrayList<TurnHistoryBean> turnHistory) {
		this.turnHistory = turnHistory;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * @return the prisoner
	 */
	public boolean isPrisoner() {
		return prisoner;
	}

	/**
	 * @param prisoner the prisoner to set
	 */
	public void setPrisoner(boolean prisoner) {
		this.prisoner = prisoner;
	}
	
	/**
	 * @return the properties
	 */
	public ArrayList<PropertyTile> getProperties() {
		return properties;
	}
}
