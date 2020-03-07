package org.virajshah.monopoly.core;

import org.virajshah.monopoly.beans.TurnHistoryBean;
import org.virajshah.monopoly.logger.InfoLog;
import org.virajshah.monopoly.logger.Logger;
import org.virajshah.monopoly.logger.RentTransactionLog;
import org.virajshah.monopoly.tiles.ColoredProperty;
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
@SuppressWarnings("unused")
public class MonopolyGame {
    private static final int JAIL_INDEX = 10;
    private static final Random random = new Random();
    private Tile[] board;
    private ArrayList<Player> players;
    private ArrayList<Player> bankruptedPlayers;
    private int gameId;
    private int currPlayer;
    private static Logger logger = new Logger(MonopolyGame.class);

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
        logger.log(new InfoLog(String.format("%s has been added to the game", p.getName())));
    }

    /**
     * Simulate the next player's turn
     */
    public void runNextTurn() {
        if (players.isEmpty()) {
            logger.log(new InfoLog("There are no remaining players"));
            return;
        }

        currPlayer++;

        if (currPlayer >= players.size())
            currPlayer = 0;

        // Initialize the player and fill in some TurnHistoryBean fields
        Player player = players.get(currPlayer);
        TurnHistoryBean turn = new TurnHistoryBean();
        player.getTurnHistory().add(turn);
        turn.setTurnNumber(player.getTurnHistory().size());
        turn.setDiceRoll1(random.nextInt(7));
        turn.setDiceRoll2(random.nextInt(7));
        turn.setOrigin(player.getPosition());
        turn.setOriginInJail(player.isPrisoner());
        turn.setInitialBalance(player.getBalance());

        // Log any relevant info at this time
        logger.log(new InfoLog(String.format("It is %s's turn #%d. Starting at %s", player.getName(), turn.getTurnNumber(), board[turn.getOrigin()])));
        logger.log(new InfoLog(String.format("Dice Roll: %d and %d = %d", turn.getDiceRoll1(), turn.getDiceRoll2(), turn.getDiceRoll1() + turn.getDiceRoll2())));

        if (player.isPrisoner() && turn.getDiceRoll1() == turn.getDiceRoll2()) {
            logger.log(new InfoLog(String.format("%s is in jail, but rolled doubles (%d), and is now out of jail", player.getName(), turn.getDiceRoll1())));
        } else if (player.isPrisoner()) {
            logger.log(new InfoLog(String.format("%s is in jail, and did not roll doubles. Staying in jail.", player.getName())));
            return;
        }

        // Move the player to the next position
        player.setPosition(player.getPosition() + turn.getDiceRoll1() + turn.getDiceRoll2());
        if (player.getPosition() > 39)
            player.setPosition(player.getPosition() - 40);

        logger.log(new InfoLog(String.format("%s moved to %s", player.getName(), board[player.getPosition()].getName())));

        // Check if the tile is the "Go To Jail" tile
        if (board[player.getPosition()].getAttributes().contains(TileAttribute.GO_TO_JAIL)) {
            player.setPosition(JAIL_INDEX);
            turn.setDestinationInJail(true);
            logger.log(new InfoLog(String.format("%s is now in jail", player.getName())));
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
                logger.log(new InfoLog(String.format("%s purchased %s for $%d", player.getName(), property.getName(), property.getPrice())));
            } else if (property.isOwned() && property.getOwner() != player) {
                int rentDue = property.getRent(turn.getDiceRoll1() + turn.getDiceRoll2());
                player.sendMoney(rentDue, property.getOwner());
                logger.log(new RentTransactionLog(player, property.getOwner(), rentDue, property));
            }
        }

        turn.setRecentBalance(player.getBalance());

        // If the player is bankrupted
        if (player.getBalance() < 0) {
            bankruptedPlayers.add(player);
            players.remove(player);
            logger.log(new InfoLog(String.format("%s is now bankrupt ($%d). Removing from game.", player.getName(), player.getBalance())));
        }

        logAllPlayerUpdates();
    }

    private void logAllPlayerUpdates() {
        StringBuilder logOutput = new StringBuilder("Played Updates:\n");
        for (Player p : players) {
            logOutput.append(String.format("\t%s: $%d:%n", p.getName(), p.getBalance()));
            for (PropertyTile prop : p.getProperties()) {
                if (prop instanceof ColoredProperty) {
                    if (((ColoredProperty) prop).getHousesOnProperty() == 0)
                        logOutput.append(String.format("\t\t%-15s %s%n", prop.getSetColor(), prop.getName()));
                    else if (((ColoredProperty) prop).getHousesOnProperty() == 5)
                        logOutput.append(String.format("\t\t%-15s %s w/ Hotel%n", prop.getSetColor(), prop.getName()));
                    else
                        logOutput.append(String.format("\t\t%-15s %s %s%n", prop.getSetColor(), prop.getName(), ((ColoredProperty) prop).getHousesOnProperty()).trim());
                }
            }
        }
        String out = logOutput.toString();
        logger.log(new InfoLog(out));
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
