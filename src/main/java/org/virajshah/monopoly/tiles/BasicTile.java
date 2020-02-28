package org.virajshah.monopoly.tiles;

import java.util.List;

public class BasicTile extends Tile {
	public BasicTile(String name, List<TileAttribute> attributes) {
		super(name, attributes);
	}

	public BasicTile(String name, TileAttribute[] attributes) {
		super(name, attributes);
	}

	public BasicTile(String name, TileAttribute attribute) {
		super(name, attribute);
	}
}
