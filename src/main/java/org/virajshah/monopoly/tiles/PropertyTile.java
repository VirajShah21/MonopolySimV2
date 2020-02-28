package org.virajshah.monopoly.tiles;

import java.util.List;
import org.virajshah.monopoly.core.Player;

public abstract class PropertyTile extends Tile {
	protected Player owner;
	protected int price;

	public PropertyTile(String name, List<TileAttribute> attributes, int price) {
		super(name, attributes);
		this.price = price;
	}

	public PropertyTile(String name, TileAttribute[] attributes, int price) {
		super(name, attributes);
		this.price = price;
	}

	public PropertyTile(String name, TileAttribute attribute, int price) {
		super(name, attribute);
		this.price = price;
	}

	public boolean isOwned() {
		return owner != null;
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	public boolean purchase(Player purchaser) {
		if (!isOwned()) {
			purchaser.transaction(-price);
			owner = purchaser;
			return true;
		} else {
			return false;
		}
	}

	public abstract int getRent();

	public abstract int getRent(int roll);
}
