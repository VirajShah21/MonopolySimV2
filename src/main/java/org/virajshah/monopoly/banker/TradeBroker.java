package org.virajshah.monopoly.banker;

import org.virajshah.monopoly.core.Player;
import org.virajshah.monopoly.tiles.ColoredProperty;
import org.virajshah.monopoly.tiles.PropertyTile;
import org.virajshah.monopoly.tiles.Tile;
import org.virajshah.monopoly.tiles.TileAttribute;

import java.util.HashMap;
import java.util.Map;

public class TradeBroker {
    Player client;

    public TradeBroker(Player client) {
        this.client = client;
    }

    public Map<PropertyTile, Integer> assignPropertyValues() {
        HashMap<PropertyTile, Integer> values = new HashMap<>();

        for (PropertyTile prop : client.getProperties()) {
            int value = prop.getPrice();

            if (attributeCompletion(prop.getSetAttribute()) == 1) {
                value += countHousesOnSet(prop.getSetAttribute()) * ((ColoredProperty) prop).getHouseCost();
                value *= 4;
            } else if (attributeCompletion(prop.getSetAttribute()) >= 0.66) {
                value *= 3;
            } else if (attributeCompletion(prop.getSetAttribute()) >= 0.5) {
                value *= 2;
            } else {
                value *= 1.5;
            }
            values.put(prop, value);
        }

        return values;
    }

    public double attributeCompletion(TileAttribute attr) {
        int count = 0;
        int total = 0;

        for (PropertyTile prop : client.getProperties())
            if (prop.getAttributes().contains(attr))
                count++;

        for (Tile tile : client.getGame().getBoard())
            if (tile.getAttributes().contains(attr))
                total++;

        return (double) count / total;
    }

    public int countHousesOnSet(TileAttribute set) {
        int count = 0;
        for (PropertyTile prop : client.getProperties())
            if (prop.getAttributes().contains(set))
                count += ((ColoredProperty) prop).getHousesOnProperty();
        return count;
    }

    public int countPropertiesWithAttribute(TileAttribute attr) {
        int count = 0;
        for (PropertyTile prop : client.getProperties())
            if (prop.getAttributes().contains(attr))
                count++;

        return count;
    }
}
