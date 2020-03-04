package org.virajshah.monopoly.core.beans

import java.util.*

class TurnHistoryBean {
    var turnNumber = 0
    var diceRoll1 = 0
    var diceRoll2 = 0
    var origin = 0
    var destination = 0
    var isOriginInJail = false
    var isDestinationInJail = false
    var initialBalance = 0
    var recentBalance = 0
    var newProperties: ArrayList<Int>
    var lostProperties: ArrayList<Int>

    fun getNewProperties(): List<Int> {
        return newProperties
    }

    fun setNewProperties(newProperties: List<Int>) {
        this.newProperties = newProperties as ArrayList<Int>
    }

    fun getLostProperties(): List<Int> {
        return lostProperties
    }

    fun setLostProperties(lostProperties: List<Int>) {
        this.lostProperties = lostProperties as ArrayList<Int>
    }

    init {
        newProperties = ArrayList()
        lostProperties = ArrayList()
    }
}