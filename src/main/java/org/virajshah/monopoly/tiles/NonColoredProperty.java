package org.virajshah.monopoly.tiles;

public class NonColoredProperty extends PropertyTile {
	public NonColoredProperty(String name, TileAttribute propType) {
		super(name, new TileAttribute[] { TileAttribute.PROPERTY, propType }, propType == TileAttribute.RAILROAD ? 200 : 150);
	}

	@Override
	public int getRent() {
		// TODO: Implement this
		return 0;
	}

	@Override
	public int getRent(int roll) {
		// TODO: Implement this
		return 0;
	}
}
