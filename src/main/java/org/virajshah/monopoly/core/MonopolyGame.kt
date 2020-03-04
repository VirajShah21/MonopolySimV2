package org.virajshah.monopoly.core

import org.virajshah.monopoly.core.beans.TurnHistoryBean
import org.virajshah.monopoly.tiles.PropertyTile
import org.virajshah.monopoly.tiles.Tile
import org.virajshah.monopoly.tiles.TileAttribute
import java.util.*

/**
 * The MonopolyGame class is responsible for handling all functions of an
 * instance of a Monopoly game.
 *
 * @author Viraj Shah
 */
class MonopolyGame {
    val board: Array<Tile?>
    val gameId: Int

    var players: ArrayList<Player>
    var bankruptedPlayers: ArrayList<Player>
    var currPlayer: Int

    fun addPlayer(p: Player) {
        players.add(p)
        p.game = this
    }

    fun runNextTurn() {
        if (players.isEmpty()) return
        currPlayer++
        if (currPlayer >= players.size) currPlayer = 0
        // Initialize the player and fill in some TurnHistoryBean fields
        val player = players[currPlayer]
        val turn = TurnHistoryBean()
        turn.turnNumber = player.turnHistory.size
        turn.diceRoll1 = random.nextInt(7)
        turn.diceRoll2 = random.nextInt(7)
        turn.origin = player.position
        turn.isOriginInJail = player.isPrisoner
        turn.initialBalance = player.balance
        // Log any relevant info at this time
//		logs.info(String.format("It is %s's turn #%d", player.getName(), turn.getTurnNumber()));
//		logs.info(String.format("%s rolled a %d and %d (%d)", player.getName(), turn.getDiceRoll1(),
//				turn.getDiceRoll2(), turn.getDiceRoll1() + turn.getDiceRoll2()));
// Move the player to the next position
        player.position = player.position + turn.diceRoll1 + turn.diceRoll2
        if (player.position > 39) player.position = player.position - 40
        // Check if the tile is the "Go To Jail" tile
        if (board[player.position]!!.attributes.contains(TileAttribute.GO_TO_JAIL)) { //			logs.info(String.format("%s landed on Go To Jail", player.getName()));
            player.position = JAIL_INDEX
            turn.isDestinationInJail = true
            // Log any relevant info at this time
//			logs.info(String.format("%s is now in jail.", player.getName()));
//			logs.info(String.format("%s moved from %s to %s", player.getName(), board[turn.getOrigin()].getName(),
//					board[turn.getDestination()].getName()));
            return
        }
        turn.isDestinationInJail = false
        turn.destination = player.position
        // If the player landed on a property:
        if (board[player.position]!!.attributes.contains(TileAttribute.PROPERTY)) {
            val property = board[player.position] as PropertyTile
            if (!property.isOwned && player.balance > property.price) {
                property.purchase(player)
                turn.newProperties.add(player.position)
                //				logs.info(String.format("%s bought %s for $%d.", player.getName(), property.getName(),
//						property.getPrice()));
            } else if (property.isOwned) {
                if (property.attributes.contains(TileAttribute.UTILITY)) {
                    player.sendMoney(property.getRent(turn.diceRoll1 + turn.diceRoll2), property.owner!!)
                    //					logs.info(String.format("%s payed $%d to %s for rent on %s", player.getName(),
//							property.getRent(turn.getDiceRoll1() + turn.getDiceRoll2()), property.getOwner().getName(),
//							property.getName()));
                } else {
                    player.sendMoney(property.rent, property.owner!!)
                    //					logs.info(String.format("%s payed $%d to %s for rent on %s", player.getName(), property.getRent(),
//							property.getOwner().getName(), property.getName()));
                }
            }
        }
        turn.recentBalance = player.balance
        //		logs.info(String.format("%s now has a balance of $%d", player.getName(), player.getBalance()));
        player.turnHistory.add(turn)
        // If the player is bankrupted
        if (player.balance < 0) {
            bankruptedPlayers.add(player)
            players.remove(player)
        }
    }

    companion object {
        private const val JAIL_INDEX = 10
        private val random = Random()
    }

    init {
        board = Tile.buildBoard()
        players = ArrayList()
        bankruptedPlayers = ArrayList()
        gameId = random.nextInt(Int.MAX_VALUE)
        currPlayer = 0
    }
}