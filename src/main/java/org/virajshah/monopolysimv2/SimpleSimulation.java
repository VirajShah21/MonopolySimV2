package org.virajshah.monopolysimv2;

import org.virajshah.monopoly.core.MonopolyGame;
import org.virajshah.monopoly.core.Player;

public class SimpleSimulation {
	public static void main(String[] args) {
		MonopolyGame game = new MonopolyGame();

		game.addPlayer(new Player("Player 1"));
		game.addPlayer(new Player("Player 2"));
		game.addPlayer(new Player("Player 3"));
		game.addPlayer(new Player("Player 4"));

		for (int i = 0; i < 1000; i++) {
			game.runNextTurn();

			if (game.getPlayers().isEmpty() || game.getPlayers().size() == 1) {
				MonopolyGame.getLogs().info(String.format("Game Over! Simulator is terminating.%nThe last player is %s with $%d", game.getPlayers().get(0).getName(), game.getPlayers().get(0).getBalance()));
				System.exit(0);
			}
		}
	}
}
