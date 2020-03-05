package org.virajshah.monopoly.tiles;

public class ColoredProperty extends PropertyTile {
	private int[] rents;
	private int housesOnProperty;
	
	/**
	 * @param name The name of the property
	 * @param price The price to purchase the property
	 * @param rentList The list of rent based on number of houses
	 * @param set The attribute of the color group/set
	 */
	public ColoredProperty(String name, int price, int[] rentList, TileAttribute set) {
		super(name, new TileAttribute[] { TileAttribute.PROPERTY, set, TileAttribute.COLORED_PROPERTY }, price);
		rents = rentList;
		housesOnProperty = 0;
	}
	
	@Override
	public int getRent() {
		return rents[housesOnProperty];
	}

	@Override
	public int getRent(int roll) {
		return rents[housesOnProperty];
	}

	/**
	 * @return the housesOnProperty
	 */
	public int getHousesOnProperty() {
		return housesOnProperty;
	}

	/**
	 * @param housesOnProperty the housesOnProperty to set
	 */
	public void setHousesOnProperty(int housesOnProperty) {
		this.housesOnProperty = housesOnProperty;
	}

	/**
	 * @return the rents
	 */
	public int[] getRents() {
		return rents;
	}
}
