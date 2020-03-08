package org.virajshah.monopoly.banker;

import org.virajshah.monopoly.core.Player;

public class TradeDeal {
    private Player player1;
    private Player player2;

    public TradeDeal(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
