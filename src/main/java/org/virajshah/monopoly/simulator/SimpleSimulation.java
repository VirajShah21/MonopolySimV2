package org.virajshah.monopoly.simulator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.virajshah.monopoly.core.MonopolyGame;
import org.virajshah.monopoly.core.Player;

public class SimpleSimulation {
    private static Logger logger = LoggerFactory.getLogger(SimpleSimulation.class);

    public static void main(String[] args) {
        logger.info("Hi");
        MonopolyGame game = new MonopolyGame();

        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.addPlayer(new Player("Player 4"));

        for (int i = 0; i < 1000; i++) {
            game.runNextTurn();

            if (game.getPlayers().isEmpty() || game.getPlayers().size() == 1) {
                System.exit(0);
            }
        }
    }
}
