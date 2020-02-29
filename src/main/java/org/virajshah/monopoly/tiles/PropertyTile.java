package org.virajshah.monopoly.tiles;

import java.util.List;
import org.virajshah.monopoly.core.Player;

public abstract class PropertyTile extends Tile {
	protected Player owner;
	protected int price;

	/**
	 * @param name       The name of the property
	 * @param attributes The attributes associated with the property
	 * @param price      The price to purchase the property
	 */
	public PropertyTile(String name, List<TileAttribute> attributes, int price) {
		super(name, attributes);
		this.price = price;
	}

	/**
	 * @param name       The name of the property
	 * @param attributes The attributes associated with the property
	 * @param price      The price to purchase the property
	 */
	public PropertyTile(String name, TileAttribute[] attributes, int price) {
		super(name, attributes);
		this.price = price;
	}

	/**
	 * @param name       The name of the property
	 * @param attributes The attributes associated with the property
	 * @param price      The price to purchase the property
	 */
	public PropertyTile(String name, TileAttribute attribute, int price) {
		super(name, attribute);
		this.price = price;
	}

	/**
	 * @return True if the property is owned; false otherwise
	 */
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

	/**
	 * Purchase the property
	 * 
	 * @param purchaser The player purchasing the property
	 * @return True if the property is unowned and property was purchased; false
	 *         otherwise
	 */
	public boolean purchase(Player purchaser) {
		if (!isOwned()) {
			purchaser.addMoney(-price);
			owner = purchaser;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get the rent of a property
	 * 
	 * @return The amount due on rent
	 */
	public abstract int getRent();

	/**
	 * Get the rent of a property (based on dice rolls for Utilities)
	 * 
	 * @param roll The sum of the dice rolls
	 * @return The rent due on the property
	 */
	public abstract int getRent(int roll);
}
