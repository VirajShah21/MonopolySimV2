package org.virajshah.monopoly.banker;

import org.virajshah.monopoly.core.Player;
import org.virajshah.monopoly.tiles.PropertyTile;

import java.util.ArrayList;
import java.util.List;

public class TradeDeal {
    private Player player1;
    private Player player2;
    private List<PropertyTile> player1acquisitions;
    private List<PropertyTile> player2acquisitions;
    private int compensation; // net amount from player 1 to player 2

    public TradeDeal(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
        player1acquisitions = new ArrayList<>();
        player2acquisitions = new ArrayList<>();
        compensation = 0;
    }

    public void execute() {
        for (PropertyTile prop : player1acquisitions)
            prop.transferOwnership(player1);

        for (PropertyTile prop : player2acquisitions)
            prop.transferOwnership(player2);


        player1.addMoney(-compensation);
        player2.addMoney(compensation);
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public List<PropertyTile> getPlayer1acquisitions() {
        return player1acquisitions;
    }

    public void setPlayer1acquisitions(List<PropertyTile> player1acquisitions) {
        this.player1acquisitions = player1acquisitions;
    }

    public List<PropertyTile> getPlayer2acquisitions() {
        return player2acquisitions;
    }

    public void setPlayer2acquisitions(List<PropertyTile> player2acquisitions) {
        this.player2acquisitions = player2acquisitions;
    }

    public int getCompensation() {
        return compensation;
    }

    public void setCompensation(int compensation) {
        this.compensation = compensation;
    }
}
