package org.virajshah.monopoly.banker;

import org.jetbrains.annotations.NotNull;
import org.virajshah.monopoly.core.Player;
import org.virajshah.monopoly.tiles.ColoredProperty;
import org.virajshah.monopoly.tiles.PropertyTile;
import org.virajshah.monopoly.tiles.Tile;
import org.virajshah.monopoly.tiles.TileAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeBroker {
    Player client;

    public static int countPropertiesWithAttribute(@NotNull Player p, TileAttribute attr) {
        int count = 0;
        for (PropertyTile prop : p.getProperties())
            if (prop.getAttributes().contains(attr))
                count++;
        return count;
    }

    public TradeBroker(Player client) {
        this.client = client;
    }

    public Map<PropertyTile, Integer> assignPropertyValues() {
        HashMap<PropertyTile, Integer> values = new HashMap<>();

        for (PropertyTile prop : client.getProperties()) {
            int value = prop.getPrice();

            if (getAttributeCompletion(prop.getSetAttribute()) == 1) {
                value += countHousesOnSet(prop.getSetAttribute()) * ((ColoredProperty) prop).getHouseCost();
                value *= 4;
            } else if (getAttributeCompletion(prop.getSetAttribute()) >= 0.66) {
                value *= 3;
            } else if (getAttributeCompletion(prop.getSetAttribute()) >= 0.5) {
                value *= 2;
            } else {
                value *= 1.5;
            }
            values.put(prop, value);
        }

        return values;
    }

    public double getAttributeCompletion(TileAttribute attr) {
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

    public Map<TileAttribute, Double> getAttributeCompletions() {
        HashMap<TileAttribute, Double> out = new HashMap<>();

        for (PropertyTile prop : client.getProperties()) {
            TileAttribute attr = prop.getSetAttribute();
            out.put(attr, getAttributeCompletion(attr));
        }

        return out;
    }

    public int countHousesOnSet(TileAttribute set) {
        int count = 0;
        for (PropertyTile prop : client.getProperties())
            if (prop.getAttributes().contains(set))
                count += ((ColoredProperty) prop).getHousesOnProperty();
        return count;
    }

    public TileAttribute getMostWantedSet() {
        Map<TileAttribute, Double> completions = getAttributeCompletions();
        TileAttribute largest = null;
        for (PropertyTile prop : client.getProperties()) {
            if (largest == null)
                largest = prop.getSetAttribute();

            if (completions.get(prop.getSetAttribute()) > completions.get(largest))
                largest = prop.getSetAttribute();
        }
        return largest;
    }

    public Player getBestTraderMatch() {
        List<Player> players = client.getGame().getPlayers();
        Player bestPlayer = players.get(0);
        TileAttribute mostWantedSet = getMostWantedSet();

        for (Player player : players)
            if (countPropertiesWithAttribute(player, mostWantedSet) > countPropertiesWithAttribute(bestPlayer, mostWantedSet))
                bestPlayer = player;

        return bestPlayer;
    }
}
