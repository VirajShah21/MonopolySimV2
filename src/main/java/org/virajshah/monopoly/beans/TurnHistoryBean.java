package org.virajshah.monopoly.beans;

import org.virajshah.json.Json;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class TurnHistoryBean {
    private int turnNumber;
    private int diceRoll1;
    private int diceRoll2;
    private int origin;
    private int destination;
    private boolean originInJail;
    private boolean destinationInJail;
    private int initialBalance;
    private int recentBalance;
    private ArrayList<Integer> newProperties;
    private ArrayList<Integer> lostProperties;

    public TurnHistoryBean() {
        newProperties = new ArrayList<>();
        lostProperties = new ArrayList<>();
    }

    /**
     * @return the turnNumber
     */
    public int getTurnNumber() {
        return turnNumber;
    }

    /**
     * @param turnNumber the turnNumber to set
     */
    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    /**
     * @return the diceRoll1
     */
    public int getDiceRoll1() {
        return diceRoll1;
    }

    /**
     * @param diceRoll1 the diceRoll1 to set
     */
    public void setDiceRoll1(int diceRoll1) {
        this.diceRoll1 = diceRoll1;
    }

    /**
     * @return the diceRoll2
     */
    public int getDiceRoll2() {
        return diceRoll2;
    }

    /**
     * @param diceRoll2 the diceRoll2 to set
     */
    public void setDiceRoll2(int diceRoll2) {
        this.diceRoll2 = diceRoll2;
    }

    /**
     * @return the origin
     */
    public int getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(int origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public int getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(int destination) {
        this.destination = destination;
    }

    /**
     * @return the originInJail
     */
    public boolean isOriginInJail() {
        return originInJail;
    }

    /**
     * @param originInJail the originInJail to set
     */
    public void setOriginInJail(boolean originInJail) {
        this.originInJail = originInJail;
    }

    /**
     * @return the destinationInJail
     */
    public boolean isDestinationInJail() {
        return destinationInJail;
    }

    /**
     * @param destinationInJail the destinationInJail to set
     */
    public void setDestinationInJail(boolean destinationInJail) {
        this.destinationInJail = destinationInJail;
    }

    /**
     * @return the initialBalance
     */
    public int getInitialBalance() {
        return initialBalance;
    }

    /**
     * @param initialBalance the initialBalance to set
     */
    public void setInitialBalance(int initialBalance) {
        this.initialBalance = initialBalance;
    }

    /**
     * @return the recentBalance
     */
    public int getRecentBalance() {
        return recentBalance;
    }

    /**
     * @param recentBalance the recentBalance to set
     */
    public void setRecentBalance(int recentBalance) {
        this.recentBalance = recentBalance;
    }

    /**
     * @return the newProperties
     */
    public List<Integer> getNewProperties() {
        return newProperties;
    }

    /**
     * @param newProperties the newProperties to set
     */
    public void setNewProperties(List<Integer> newProperties) {
        this.newProperties = (ArrayList<Integer>) newProperties;
    }

    /**
     * @return the lostProperties
     */
    public List<Integer> getLostProperties() {
        return lostProperties;
    }

    /**
     * @param lostProperties the lostProperties to set
     */
    public void setLostProperties(List<Integer> lostProperties) {
        this.lostProperties = (ArrayList<Integer>) lostProperties;
    }

    public Json toJson() {
        Json out = new Json();
        out.put("turnNumber", turnNumber);
        out.put("diceRoll1", diceRoll1);
        out.put("diceRoll2", diceRoll1);
        out.put("origin", origin);
        out.put("destination", destination);
        out.put("originInJail", originInJail);
        out.put("destinationInJail", destinationInJail);
        out.put("initialBalance", initialBalance);
        out.put("recentBalance", recentBalance);
        out.put("newProperties", newProperties);
        out.put("lostProperties", lostProperties);
        return out;
    }
}
