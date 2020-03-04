package org.virajshah.monopoly.core

import org.virajshah.monopoly.core.beans.PlayerDNABean
import org.virajshah.monopoly.core.beans.TurnHistoryBean
import org.virajshah.monopoly.tiles.PropertyTile
import java.util.*

class Player {
     var name: String? = null
     var balance: Int
     lateinit var game: MonopolyGame
     var position: Int
     var isPrisoner = false
     var turnHistory: ArrayList<TurnHistoryBean>
     var properties: ArrayList<PropertyTile?>
     var dna: PlayerDNABean

    constructor(name: String) {
        this.name = name
        balance = 1500
        position = 0
        turnHistory = ArrayList()
        properties = ArrayList()
        dna = PlayerDNABean()
    }

    fun sendMoney(amount: Int, other: Player) {
        balance -= amount;
        other.balance += amount;
    }
}