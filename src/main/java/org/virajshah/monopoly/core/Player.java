package org.virajshah.monopoly.core;

import java.util.ArrayList;
import java.util.List;

import org.virajshah.monopoly.core.beans.PlayerDNABean;
import org.virajshah.monopoly.core.beans.TurnHistoryBean;
import org.virajshah.monopoly.tiles.PropertyTile;
import org.virajshah.monopoly.tiles.TileAttribute;

public class Player {
	private String name;
	private int balance;
	private MonopolyGame game;
	private int position;
	private boolean prisoner;
	private ArrayList<TurnHistoryBean> turnHistory;
	private ArrayList<PropertyTile> properties;
	private PlayerDNABean dna;

	/**
	 * @param name The player's name (doesn't really matter)
	 */
	public Player(String name) {
		this.name = name;
		this.balance = 1500;
		position = 0;
		turnHistory = new ArrayList<>();
		properties = new ArrayList<>();
		dna = new PlayerDNABean();
	}

	/**
	 * Default constructor
	 */
	public Player() {
		this.balance = 1500;
		position = 0;
		turnHistory = new ArrayList<>();
		properties = new ArrayList<>();
		dna = new PlayerDNABean();
	}

	/**
	 * Transfer money from one player to another
	 * 
	 * @param amount The amount to be transfered (positive to send money; negative
	 *               to receive)
	 * @param other  The other player involved in the transaction
	 */
	public void sendMoney(int amount, Player other) {
		addMoney(-amount);
		other.addMoney(amount);
	}

	/**
	 * Add money to the player's balance
	 * 
	 * @param amount The amount of money to add
	 */
	public void addMoney(int amount) {
		balance += amount;
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
	public List<TurnHistoryBean> getTurnHistory() {
		return turnHistory;
	}

	/**
	 * @param turnHistory the turnHistory to set
	 */
	public void setTurnHistory(List<TurnHistoryBean> turnHistory) {
		this.turnHistory = (ArrayList<TurnHistoryBean>) turnHistory;
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
	public List<PropertyTile> getProperties() {
		return properties;
	}

	/**
	 * @return the dna
	 */
	public PlayerDNABean getDna() {
		return dna;
	}

	/**
	 * @param dna the dna to set
	 */
	public void setDna(PlayerDNABean dna) {
		this.dna = dna;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(ArrayList<PropertyTile> properties) {
		this.properties = properties;
	}
}
