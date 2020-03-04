package org.virajshah.monopoly.core.beans

import java.util.*

class PlayerDNABean {
    var spendingTolerance = 0.0
    var negotiationSettlement = 0.0
    var quickBuilder = 0.0

    companion object {
        private val random = Random()
    }

    init {
        spendingTolerance = random.nextDouble()
        negotiationSettlement = 1 + random.nextDouble()
        quickBuilder = random.nextDouble() * 11 + 1
    }
}