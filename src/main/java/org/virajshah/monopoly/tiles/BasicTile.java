package org.virajshah.monopoly.tiles;

import java.util.List;

public class BasicTile extends Tile {
	/**
	 * @param name       The name of the tile
	 * @param attributes Attributes associated with the tile
	 */
	public BasicTile(String name, List<TileAttribute> attributes) {
		super(name, attributes);
	}

	/**
	 * @param name       The name of the tile
	 * @param attributes Attributes associated with the tile
	 */
	public BasicTile(String name, TileAttribute[] attributes) {
		super(name, attributes);
	}

	/**
	 * @param name       The name of the tile
	 * @param attributes Attributes associated with the tile
	 */
	public BasicTile(String name, TileAttribute attribute) {
		super(name, attribute);
	}
}
