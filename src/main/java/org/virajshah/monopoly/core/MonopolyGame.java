package org.virajshah.monopoly.core;

import java.util.ArrayList;
import java.util.List;
import org.virajshah.monopoly.tiles.Tile;

/**
 * The MonopolyGame class is responsible for handling all functions of an
 * instance of a Monopoly game.
 * 
 * @author Viraj Shah
 */
public class MonopolyGame {
	private Tile[] board;
	private ArrayList<Player> players;
	private long gameId;
	private int currPlayer;

	public MonopolyGame() {
		board = Tile.buildBoard();
		players = new ArrayList<>();
		gameId = (int) (Math.random() * Long.MAX_VALUE);
		currPlayer = 0;
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	/**
	 * @return the board
	 */
	public Tile[] getBoard() {
		return board;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @return the gameId
	 */
	public long getGameId() {
		return gameId;
	}

	/**
	 * @return the currPlayer
	 */
	public int getCurrPlayer() {
		return currPlayer;
	}
}
