package org.virajshah.monopoly.core;

import org.virajshah.monopoly.beans.TurnHistoryBean;
import org.virajshah.monopoly.tiles.PropertyTile;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Player {
    private String name;
    private int balance;
    private MonopolyGame game;
    private int position;
    private boolean prisoner;
    private List<TurnHistoryBean> turnHistory;
    private List<PropertyTile> properties;

    /**
     * @param name The player's name (doesn't really matter)
     */
    public Player(String name) {
        this.name = name;
        this.balance = 1500;
        position = 0;
        turnHistory = new ArrayList<>();
        properties = new ArrayList<>();
    }

    /**
     * Default constructor
     */
    public Player() {
        this.balance = 1500;
        position = 0;
        turnHistory = new ArrayList<>();
        properties = new ArrayList<>();
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
    public List<PropertyTile> getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(List<PropertyTile> properties) {
        this.properties = properties;
    }
}
