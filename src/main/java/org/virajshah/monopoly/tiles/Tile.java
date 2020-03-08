package org.virajshah.monopoly.tiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Tile class is the superclass for all the squares on a Monopoly game
 * board. The class has two fields inherited by all children: TYPE, and NAME.
 *
 * @author Viraj Shah
 */
public abstract class Tile {
    private static final String CHANCE_LABEL = "Chance";
    private static final String CHEST_LABEL = "Community Chest";

    protected ArrayList<TileAttribute> attributes;
    protected String name;

    /**
     * @param name       The name of the tile
     * @param attributes The attributes associated with the tile
     */
    public Tile(String name, List<TileAttribute> attributes) {
        this.name = name;
        this.attributes = (ArrayList<TileAttribute>) attributes;
    }

    /**
     * @param name       The name of the tile
     * @param attributes The attributes associated with the tile
     */
    public Tile(String name, TileAttribute[] attributes) {
        this.name = name;
        this.attributes = new ArrayList<>();
        this.attributes.addAll(Arrays.asList(attributes));
    }

    /**
     * @param name      The name of the tile
     * @param attribute The attributes associated with the tile
     */
    public Tile(String name, TileAttribute attribute) {
        this.name = name;
        this.attributes = new ArrayList<>();
        this.attributes.add(attribute);
    }

    /**
     * @return the attributes
     */
    public List<TileAttribute> getAttributes() {
        return attributes;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Builds a game board
     *
     * @return The Monopoly game board which was built
     */
    public static Tile[] buildBoard() {
        Tile[] out = new Tile[40];

        out[0] = new BasicTile("Go", TileAttribute.GO);
        out[1] = new ColoredProperty("Mediterranean Avenue", 60, new int[]{2, 10, 30, 90, 160, 250},
                TileAttribute.SET1);
        out[2] = new BasicTile(CHEST_LABEL, TileAttribute.CHEST);
        out[3] = new ColoredProperty("Baltic Avenue", 60, new int[]{4, 20, 60, 180, 320, 450}, TileAttribute.SET1);
        out[4] = new BasicTile("Tax", TileAttribute.TAX);
        out[5] = new NonColoredProperty("Reading Railroad", TileAttribute.RAILROAD);
        out[6] = new ColoredProperty("Oriental Avenue", 100, new int[]{6, 30, 90, 270, 400, 550},
                TileAttribute.SET2);
        out[7] = new BasicTile(CHANCE_LABEL, TileAttribute.CHANCE);
        out[8] = new ColoredProperty("Vermont Avenue", 100, new int[]{6, 30, 90, 270, 400, 550}, TileAttribute.SET2);
        out[9] = new ColoredProperty("Connecticut Avenue", 120, new int[]{8, 40, 100, 300, 450, 600},
                TileAttribute.SET2);
        out[10] = new BasicTile("Jail", TileAttribute.JAIL);
        out[11] = new ColoredProperty("St. Charles Place", 140, new int[]{10, 50, 150, 450, 625, 750},
                TileAttribute.SET3);
        out[12] = new NonColoredProperty("Electric Company", TileAttribute.UTILITY);
        out[13] = new ColoredProperty("States Avenue", 140, new int[]{10, 50, 150, 450, 625, 750},
                TileAttribute.SET3);
        out[14] = new ColoredProperty("Virginia Avenue", 160, new int[]{12, 60, 180, 500, 700, 900},
                TileAttribute.SET3);
        out[15] = new NonColoredProperty("Pennsylvania Railroad", TileAttribute.RAILROAD);
        out[16] = new ColoredProperty("St. James Place", 180, new int[]{14, 70, 200, 550, 750, 950},
                TileAttribute.SET4);
        out[17] = new BasicTile(CHEST_LABEL, TileAttribute.CHEST);
        out[18] = new ColoredProperty("Tennessee Avenue", 180, new int[]{14, 70, 200, 550, 750, 950},
                TileAttribute.SET4);
        out[19] = new ColoredProperty("New York Avenue", 200, new int[]{16, 80, 220, 600, 800, 1000},
                TileAttribute.SET4);
        out[20] = new BasicTile("Free Parking", TileAttribute.FREE_PARKING);
        out[21] = new ColoredProperty("Kentucky Avenue", 220, new int[]{18, 90, 250, 700, 875, 1050},
                TileAttribute.SET5);
        out[22] = new BasicTile(CHANCE_LABEL, TileAttribute.CHANCE);
        out[23] = new ColoredProperty("Indiana Avenue", 220, new int[]{18, 90, 250, 700, 875, 1050},
                TileAttribute.SET5);
        out[24] = new ColoredProperty("Illinois Avenue", 240, new int[]{20, 100, 300, 750, 925, 1100},
                TileAttribute.SET5);
        out[25] = new NonColoredProperty("B. & O. Railroad", TileAttribute.RAILROAD);
        out[26] = new ColoredProperty("Atlantic Avenue", 260, new int[]{22, 110, 330, 800, 975, 1150},
                TileAttribute.SET6);
        out[27] = new ColoredProperty("Ventnor Avenue", 260, new int[]{22, 110, 330, 800, 975, 1150},
                TileAttribute.SET6);
        out[28] = new NonColoredProperty("Waterworks", TileAttribute.RAILROAD);
        out[29] = new ColoredProperty("Marvin Gardens", 280, new int[]{24, 120, 360, 850, 1025, 1200},
                TileAttribute.SET6);
        out[30] = new BasicTile("Go to Jail", TileAttribute.GO_TO_JAIL);
        out[31] = new ColoredProperty("Pacific Avenue", 300, new int[]{26, 130, 390, 900, 1100, 1275},
                TileAttribute.SET7);
        out[32] = new ColoredProperty("North Carolina Avenue", 300, new int[]{26, 130, 390, 900, 1100, 1275},
                TileAttribute.SET7);
        out[33] = new BasicTile(CHEST_LABEL, TileAttribute.CHEST);
        out[34] = new ColoredProperty("Pennsylvania Avenue", 320, new int[]{28, 150, 450, 1000, 1200, 1400},
                TileAttribute.SET7);
        out[35] = new NonColoredProperty("Short Line", TileAttribute.RAILROAD);
        out[36] = new BasicTile(CHANCE_LABEL, TileAttribute.CHANCE);
        out[37] = new ColoredProperty("Park Place", 350, new int[]{35, 175, 500, 1100, 1300, 1500},
                TileAttribute.SET8);
        out[38] = new BasicTile("Tax", TileAttribute.TAX);
        out[39] = new ColoredProperty("Boardwalk", 400, new int[]{50, 200, 600, 1400, 1700, 2000},
                TileAttribute.SET8);

        return out;
    }

    /**
     * @return The name of a tile
     */
    public String toString() {
        return name;
    }
}
