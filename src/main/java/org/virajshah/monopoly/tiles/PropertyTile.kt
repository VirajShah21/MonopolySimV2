package org.virajshah.monopoly.tiles

import org.virajshah.monopoly.core.Player

abstract class PropertyTile : Tile {
    var owner: Player? = null
    var price: Int
        protected set

    constructor(name: String, attributes: List<TileAttribute?>, price: Int) : super(name, attributes) {
        this.price = price
    }

    constructor(name: String, attributes: Array<TileAttribute?>, price: Int) : super(name, attributes) {
        this.price = price
    }

    constructor(name: String, attribute: TileAttribute?, price: Int) : super(name, attribute) {
        this.price = price
    }

    val colorSet: TileAttribute?
        get() {
            for (attr in attributes) {
                return when (attr) {
                    TileAttribute.SET1 -> attr
                    TileAttribute.SET2 -> attr
                    TileAttribute.SET3 -> attr
                    TileAttribute.SET4 -> attr
                    TileAttribute.SET5 -> attr
                    TileAttribute.SET6 -> attr
                    TileAttribute.SET7 -> attr
                    TileAttribute.SET8 -> attr
                    else -> null
                }
            }
            return null
        }

    fun transferOwnership(newOwner: Player?) {
        owner!!.properties.remove(this)
        newOwner!!.properties.add(this)
        owner = newOwner
    }

    val isOwned: Boolean
        get() = owner != null

    fun purchase(purchaser: Player): Boolean {
        return if (!isOwned) {
            purchaser.balance -= price
            owner = purchaser
            true
        } else {
            false
        }
    }

    abstract val rent: Int

    abstract fun getRent(roll: Int): Int
}