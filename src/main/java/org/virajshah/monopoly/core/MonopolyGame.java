package org.virajshah.monopoly.core;

import java.util.ArrayList;
import java.util.List;

import org.virajshah.monopoly.core.beans.TurnHistoryBean;
import org.virajshah.monopoly.tiles.PropertyTile;
import org.virajshah.monopoly.tiles.Tile;
import org.virajshah.monopoly.tiles.TileAttribute;

/**
 * The MonopolyGame class is responsible for handling all functions of an
 * instance of a Monopoly game.
 * 
 * @author Viraj Shah
 */
public class MonopolyGame {
	private static final int JAIL_INDEX = 10;

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
		p.setGame(this);
	}

	public void runNextTurn() {
		currPlayer++;

		if (currPlayer >= players.size())
			currPlayer = 0;

		// Initialize the player and fill in some TurnHistoryBean fields
		Player player = players.get(currPlayer);
		TurnHistoryBean turn = new TurnHistoryBean();
		turn.setTurnNumber(player.getTurnHistory().size());
		turn.setDiceRoll1((int) (Math.random() * 6) + 1);
		turn.setDiceRoll2((int) (Math.random() * 6) + 1);
		turn.setOrigin(player.getPosition());
		turn.setOriginInJail(player.isPrisoner());
		turn.setInitialBalance(player.getBalance());

		// Move the player to the next position
		player.setPosition(player.getPosition() + turn.getDiceRoll1() + turn.getDiceRoll2());
		if (player.getPosition() > 39)
			player.setPosition(player.getPosition() - 40);

		// Check if the tile is the "Go To Jail" tile
		if (board[player.getPosition()].getAttributes().contains(TileAttribute.GO_TO_JAIL)) {
			player.setPosition(JAIL_INDEX);
			turn.setDestinationInJail(true);
			return;
		}
		turn.setDestinationInJail(false);

		// If the player landed on a property:
		if (board[player.getPosition()].getAttributes().contains(TileAttribute.PROPERTY)) {
			PropertyTile property = (PropertyTile) board[player.getPosition()];

			if (!property.isOwned() && player.getBalance() > property.getPrice()) {
				property.purchase(player);
				turn.getNewProperties().add(player.getPosition());
			} else {
				player.sendMoney(property.getRent(), property.getOwner());
			}
		}
		turn.setDestination(player.getPosition());
		turn.setRecentBalance(player.getBalance());

		player.getTurnHistory().add(turn);
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
	public List<Player> getPlayers() {
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
