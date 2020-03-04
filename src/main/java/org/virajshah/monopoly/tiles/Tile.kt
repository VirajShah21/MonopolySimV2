package org.virajshah.monopoly.tiles

import java.util.*

/**
 * The Tile class is the superclass for all the squares on a Monopoly game
 * board. The class has two fields inherited by all children: TYPE, and NAME.
 *
 * @author Viraj Shah
 */
abstract class Tile {
    var attributes: ArrayList<TileAttribute?>

    var name: String
        protected set

    constructor(name: String, attributes: List<TileAttribute?>) {
        this.name = name
        this.attributes = attributes as ArrayList<TileAttribute?>
    }

    constructor(name: String, attributes: Array<TileAttribute?>) {
        this.name = name
        this.attributes = ArrayList()
        for (attr in attributes) this.attributes.add(attr)
    }

    constructor(name: String, attribute: TileAttribute?) {
        this.name = name
        attributes = ArrayList()
        attributes.add(attribute)
    }

    fun getAttributes(): List<TileAttribute?> {
        return attributes
    }


    fun setAttributes(attributes: List<TileAttribute?>) {
        this.attributes = attributes as ArrayList<TileAttribute?>
    }


    override fun toString(): String {
        return name
    }

    companion object {
        private const val CHANCE_LABEL = "Chance"
        private const val CHEST_LABEL = "Community Chest"

        fun buildBoard(): Array<Tile?> {
            val out = arrayOfNulls<Tile>(40)
            out[0] = BasicTile("Go", TileAttribute.GO)
            out[1] = ColoredProperty("Mediterranean Avenue", 60, intArrayOf(2, 10, 30, 90, 160, 250),
                    TileAttribute.SET1)
            out[2] = BasicTile(CHEST_LABEL, TileAttribute.CHEST)
            out[3] = ColoredProperty("Baltic Avenue", 60, intArrayOf(4, 20, 60, 180, 320, 450), TileAttribute.SET1)
            out[4] = BasicTile("Tax", TileAttribute.TAX)
            out[5] = NonColoredProperty("Reading Railroad", TileAttribute.RAILROAD)
            out[6] = ColoredProperty("Oriental Avenue", 100, intArrayOf(6, 30, 90, 270, 400, 550),
                    TileAttribute.SET2)
            out[7] = BasicTile(CHANCE_LABEL, TileAttribute.CHANCE)
            out[8] = ColoredProperty("Vermont Avenue", 100, intArrayOf(6, 30, 90, 270, 400, 550), TileAttribute.SET2)
            out[9] = ColoredProperty("Connecticut Avenue", 120, intArrayOf(8, 40, 100, 300, 450, 600),
                    TileAttribute.SET2)
            out[10] = BasicTile("Jail", TileAttribute.JAIL)
            out[11] = ColoredProperty("St. Charles Place", 140, intArrayOf(10, 50, 150, 450, 625, 750),
                    TileAttribute.SET3)
            out[12] = NonColoredProperty("Electric Company", TileAttribute.UTILITY)
            out[13] = ColoredProperty("States Avenue", 140, intArrayOf(10, 50, 150, 450, 625, 750),
                    TileAttribute.SET3)
            out[14] = ColoredProperty("Virginia Avenue", 160, intArrayOf(12, 60, 180, 500, 700, 900),
                    TileAttribute.SET3)
            out[15] = NonColoredProperty("Pennsylvania Railroad", TileAttribute.RAILROAD)
            out[16] = ColoredProperty("St. James Place", 180, intArrayOf(14, 70, 200, 550, 750, 950),
                    TileAttribute.SET4)
            out[17] = BasicTile(CHEST_LABEL, TileAttribute.CHEST)
            out[18] = ColoredProperty("Tennessee Avenue", 180, intArrayOf(14, 70, 200, 550, 750, 950),
                    TileAttribute.SET4)
            out[19] = ColoredProperty("New York Avenue", 200, intArrayOf(16, 80, 220, 600, 800, 1000),
                    TileAttribute.SET4)
            out[20] = BasicTile("Free Parking", TileAttribute.FREE_PARKING)
            out[21] = ColoredProperty("Kentucky Avenue", 220, intArrayOf(18, 90, 250, 700, 875, 1050),
                    TileAttribute.SET5)
            out[22] = BasicTile(CHANCE_LABEL, TileAttribute.CHANCE)
            out[23] = ColoredProperty("Indiana Avenue", 220, intArrayOf(18, 90, 250, 700, 875, 1050),
                    TileAttribute.SET5)
            out[24] = ColoredProperty("Illinois Avenue", 240, intArrayOf(20, 100, 300, 750, 925, 1100),
                    TileAttribute.SET5)
            out[25] = NonColoredProperty("B. & O. Railroad", TileAttribute.RAILROAD)
            out[26] = ColoredProperty("Atlantic Avenue", 260, intArrayOf(22, 110, 330, 800, 975, 1150),
                    TileAttribute.SET6)
            out[27] = ColoredProperty("Ventnor Avenue", 260, intArrayOf(22, 110, 330, 800, 975, 1150),
                    TileAttribute.SET6)
            out[28] = NonColoredProperty("Waterworks", TileAttribute.RAILROAD)
            out[29] = ColoredProperty("Marvin Gardens", 280, intArrayOf(24, 120, 360, 850, 1025, 1200),
                    TileAttribute.SET6)
            out[30] = BasicTile("Go to Jail", TileAttribute.GO_TO_JAIL)
            out[31] = ColoredProperty("Pacific Avenue", 300, intArrayOf(26, 130, 390, 900, 1100, 1275),
                    TileAttribute.SET7)
            out[32] = ColoredProperty("North Carolina Avenue", 300, intArrayOf(26, 130, 390, 900, 1100, 1275),
                    TileAttribute.SET7)
            out[33] = BasicTile(CHEST_LABEL, TileAttribute.CHEST)
            out[34] = ColoredProperty("Pennsylvania Avenue", 320, intArrayOf(28, 150, 450, 1000, 1200, 1400),
                    TileAttribute.SET7)
            out[35] = NonColoredProperty("Short Line", TileAttribute.RAILROAD)
            out[36] = BasicTile(CHANCE_LABEL, TileAttribute.CHANCE)
            out[37] = ColoredProperty("Park Place", 350, intArrayOf(35, 175, 500, 1100, 1300, 1500),
                    TileAttribute.SET8)
            out[38] = BasicTile("Tax", TileAttribute.TAX)
            out[39] = ColoredProperty("Boardwalk", 400, intArrayOf(50, 200, 600, 1400, 1700, 2000),
                    TileAttribute.SET8)
            return out
        }
    }
}