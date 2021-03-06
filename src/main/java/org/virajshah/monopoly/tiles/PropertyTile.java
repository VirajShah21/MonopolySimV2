package org.virajshah.monopoly.tiles;

import org.virajshah.monopoly.core.Player;

import java.util.List;

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
     * @param name      The name of the property
     * @param attribute The attributes associated with the property
     * @param price     The price to purchase the property
     */
    public PropertyTile(String name, TileAttribute attribute, int price) {
        super(name, attribute);
        this.price = price;
    }

    @SuppressWarnings("java:S131")
    public TileAttribute getSetAttribute() {
        for (TileAttribute attr : attributes) {
            switch (attr) {
                case SET1:
                    return TileAttribute.SET1;
                case SET2:
                    return TileAttribute.SET2;
                case SET3:
                    return TileAttribute.SET3;
                case SET4:
                    return TileAttribute.SET4;
                case SET5:
                    return TileAttribute.SET5;
                case SET6:
                    return TileAttribute.SET6;
                case SET7:
                    return TileAttribute.SET7;
                case SET8:
                    return TileAttribute.SET8;
                case RAILROAD:
                    return TileAttribute.RAILROAD;
                case UTILITY:
                    return TileAttribute.UTILITY;
            }
        }
        return null;
    }

    public String getSetColor() {
        switch (getSetAttribute()) {
            case SET1:
                return "Brown";
            case SET2:
                return "Light Blue";
            case SET3:
                return "Pink";
            case SET4:
                return "Orange";
            case SET5:
                return "Red";
            case SET6:
                return "Yellow";
            case SET7:
                return "Green";
            case SET8:
                return "Dark Blue";
            default:
                return "No Color";
        }
    }

    public void transferOwnership(Player newOwner) {
        owner.getProperties().remove(this);
        newOwner.getProperties().add(this);
        owner = newOwner;
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
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Purchase the property
     *
     * @param purchaser The player purchasing the property
     */
    public void purchase(Player purchaser) {
        if (!isOwned()) {
            purchaser.addMoney(-price);
            purchaser.getProperties().add(this);
            owner = purchaser;
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
