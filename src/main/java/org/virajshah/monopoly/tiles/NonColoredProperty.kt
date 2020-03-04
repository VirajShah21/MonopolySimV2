package org.virajshah.monopoly.tiles

import org.virajshah.monopoly.tiles.exceptions.RentCalculationException

class NonColoredProperty(name: String, propType: TileAttribute) : PropertyTile(name, arrayOf<TileAttribute?>(TileAttribute.PROPERTY, propType, TileAttribute.NONCOLORED_PROPERTY),
        if (propType == TileAttribute.RAILROAD) 200 else 150) {
    override val rent: Int
        get() {
            if (owner == null) {
                throw RentCalculationException(String.format("Cannot get rent on %s; no owner.", name))
            }
            return if (attributes.contains(TileAttribute.RAILROAD)) {
                var railroadCount = 0
                for (prop in owner!!.properties) if (prop!!.getAttributes().contains(TileAttribute.RAILROAD)) railroadCount++
                Math.pow(2.0, railroadCount - 1.0).toInt() * 25
            } else if (getAttributes().contains(TileAttribute.UTILITY)) {
                throw RentCalculationException(String.format("Cannot get rent on %s; dice roll sum required.", name))
            } else {
                throw RentCalculationException(String.format("Cannot get rent on %s; not of type Railroad or Utility", name))
            }
        }

    override fun getRent(roll: Int): Int {
        if (owner == null) {
            throw RentCalculationException(String.format("Cannot get rent on %s; no owner.", name))
        }
        return if (attributes.contains(TileAttribute.UTILITY)) {
            var utilityCount = 0
            for (prop in owner!!.properties) if (prop!!.getAttributes().contains(TileAttribute.UTILITY)) utilityCount++
            roll * if (utilityCount == 1) 4 else 10
        } else if (attributes.contains(TileAttribute.RAILROAD)) {
            rent
        } else {
            throw RentCalculationException(String.format("Cannot get rent on %s; not of type Railroad or Utility", name))
        }
    }
}