package org.virajshah.monopoly.simulator

import org.virajshah.monopoly.core.MonopolyGame
import org.virajshah.monopoly.core.Player

object SimpleSimulation {
    @JvmStatic
    fun main(args: Array<String>) {
        val game = MonopolyGame()
        game.addPlayer(Player("Player 1"))
        game.addPlayer(Player("Player 2"))
        game.addPlayer(Player("Player 3"))
        game.addPlayer(Player("Player 4"))
        for (i in 0..999) {
            game.runNextTurn()
            if (game.players.isEmpty() || game.players.size == 1) {
                System.exit(0)
            }
        }
    }
}