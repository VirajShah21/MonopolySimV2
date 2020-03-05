package org.virajshah.monopoly.simulator;

import org.virajshah.monopoly.core.MonopolyGame;
import org.virajshah.monopoly.core.Player;
import org.virajshah.monopoly.logger.Logger;

public class ThousandGameSimulation {
    public static void main(String[] args) {
        Logger.init();

        for (int i = 0; i < 1000; i++) {
            MonopolyGame game = new MonopolyGame();

            game.addPlayer(new Player("Player 1"));
            game.addPlayer(new Player("Player 2"));
            game.addPlayer(new Player("Player 3"));
            game.addPlayer(new Player("Player 4"));

            while (true) {
                game.runNextTurn();

                if (game.getPlayers().isEmpty() || game.getPlayers().size() == 1) {
                    break;
                }
            }
        }
    }
}
