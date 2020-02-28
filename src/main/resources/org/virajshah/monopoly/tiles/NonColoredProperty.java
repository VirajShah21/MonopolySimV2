package org.virajshah.monopoly.tiles;

import org.virajshah.monopoly.tiles.exceptions.RentCalculationException;

public class NonColoredProperty extends PropertyTile {
	public NonColoredProperty(String name, TileAttribute propType) {
		super(name, new TileAttribute[] { TileAttribute.PROPERTY, propType },
				propType == TileAttribute.RAILROAD ? 200 : 150);
	}

	@Override
	public int getRent() {
		if (owner == null) {
			throw new RentCalculationException(String.format("Cannot get rent on %s; no owner.", name));
		}

		if (attributes.contains(TileAttribute.RAILROAD)) {
			int railroadCount = 0;
			for (PropertyTile prop : owner.getProperties())
				if (prop.getAttributes().contains(TileAttribute.RAILROAD))
					railroadCount++;
			return (int) Math.pow(2, railroadCount - 1.0) * 25;
		} else if (getAttributes().contains(TileAttribute.UTILITY)) {
			throw new RentCalculationException(String.format("Cannot get rent on %s; dice roll sum required.", name));
		} else {
			throw new RentCalculationException(
					String.format("Cannot get rent on %s; not of type Railroad or Utility", name));
		}
	}

	@Override
	public int getRent(int roll) {
		if (owner == null) {
			throw new RentCalculationException(String.format("Cannot get rent on %s; no owner.", name));
		}

		if (attributes.contains(TileAttribute.UTILITY)) {
			int utilityCount = 0;
			for (PropertyTile prop : owner.getProperties())
				if (prop.getAttributes().contains(TileAttribute.UTILITY))
					utilityCount++;
			return roll * (utilityCount == 1 ? 4 : 10);
		} else if (attributes.contains(TileAttribute.RAILROAD)) {
			return getRent();
		} else {
			throw new RentCalculationException(
					String.format("Cannot get rent on %s; not of type Railroad or Utility", name));
		}
	}
}
