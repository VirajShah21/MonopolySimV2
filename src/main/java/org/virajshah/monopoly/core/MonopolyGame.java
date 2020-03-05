package org.virajshah.monopoly.core;

import org.virajshah.monopoly.core.beans.TurnHistoryBean;
import org.virajshah.monopoly.tiles.PropertyTile;
import org.virajshah.monopoly.tiles.Tile;
import org.virajshah.monopoly.tiles.TileAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The MonopolyGame class is responsible for handling all functions of an
 * instance of a Monopoly game.
 *
 * @author Viraj Shah
 */
public class MonopolyGame {
    private static final int JAIL_INDEX = 10;
    private static final Random random = new Random();
    private Tile[] board;
    private ArrayList<Player> players;
    private ArrayList<Player> bankruptedPlayers;
    private int gameId;
    private int currPlayer;

    public MonopolyGame() {
        board = Tile.buildBoard();
        players = new ArrayList<>();
        bankruptedPlayers = new ArrayList<>();
        gameId = random.nextInt(Integer.MAX_VALUE);
        currPlayer = 0;
    }

    /**
     * Add a player to the list of players
     *
     * @param p The player to add
     */
    public void addPlayer(Player p) {
        players.add(p);
        p.setGame(this);
    }

    /**
     * Simulate the next player's turn
     */
    public void runNextTurn() {
        if (players.isEmpty())
            return;

        currPlayer++;

        if (currPlayer >= players.size())
            currPlayer = 0;

        // Initialize the player and fill in some TurnHistoryBean fields
        Player player = players.get(currPlayer);
        TurnHistoryBean turn = new TurnHistoryBean();
        turn.setTurnNumber(player.getTurnHistory().size());
        turn.setDiceRoll1(random.nextInt(7));
        turn.setDiceRoll2(random.nextInt(7));
        turn.setOrigin(player.getPosition());
        turn.setOriginInJail(player.isPrisoner());
        turn.setInitialBalance(player.getBalance());

//		 Log any relevant info at this time


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
        turn.setDestination(player.getPosition());
        // If the player landed on a property:
        if (board[player.getPosition()].getAttributes().contains(TileAttribute.PROPERTY)) {
            PropertyTile property = (PropertyTile) board[player.getPosition()];

            if (!property.isOwned() && player.getBalance() > property.getPrice()) {
                property.purchase(player);
                turn.getNewProperties().add(player.getPosition());

            } else if (property.isOwned()) {
                if (property.getAttributes().contains(TileAttribute.UTILITY)) {
                    player.sendMoney(property.getRent(turn.getDiceRoll1() + turn.getDiceRoll2()), property.getOwner());

                } else {
                    player.sendMoney(property.getRent(), property.getOwner());
                }
            }
        }
        turn.setRecentBalance(player.getBalance());


        player.getTurnHistory().add(turn);

        // If the player is bankrupted
        if (player.getBalance() < 0) {
            bankruptedPlayers.add(player);
            players.remove(player);
        }
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

    /**
     * @return the bankruptedPlayers
     */
    public List<Player> getBankruptedPlayers() {
        return bankruptedPlayers;
    }

    /**
     * @param bankruptedPlayers the bankruptedPlayers to set
     */
    public void setBankruptedPlayers(List<Player> bankruptedPlayers) {
        this.bankruptedPlayers = (ArrayList<Player>) bankruptedPlayers;
    }
}
