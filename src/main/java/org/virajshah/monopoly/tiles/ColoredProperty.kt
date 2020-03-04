package org.virajshah.monopoly.tiles

class ColoredProperty(name: String, price: Int, val rents: IntArray, set: TileAttribute?) :
        PropertyTile(name, arrayOf(TileAttribute.PROPERTY, set, TileAttribute.COLORED_PROPERTY), price) {
    var housesOnProperty = 0

    override val rent: Int
        get() = rents[housesOnProperty]

    override fun getRent(roll: Int): Int {
        return rents[housesOnProperty]
    }
}