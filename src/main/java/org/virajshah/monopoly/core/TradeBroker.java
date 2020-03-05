package org.virajshah.monopoly.core;

import org.virajshah.monopoly.tiles.PropertyTile;
import org.virajshah.monopoly.tiles.TileAttribute;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TradeBroker {
    private Player client;
    private TileAttribute mostWantedSet;
    private Player match;
    private TradeBroker matchBroker;

    public TradeBroker(Player client) {
        this.client = client;
    }

    public void runInitiation() {
        mostWantedColoredSet();
        findBestPlayerMatch();
        generateTradeBrokerForMatch();
        matchBroker.runReciprocation();
        if (matchBroker.getMostWantedSet() == mostWantedSet) { // Any conflicts?
            for (PropertyTile prop : match.getProperties()) {
                if (prop.getAttributes().contains(mostWantedSet)) {
                    prop.transferOwnership(client);
                }
            }

            for (PropertyTile prop : client.getProperties()) {
                if (prop.getAttributes().contains(matchBroker.getMostWantedSet())) {
                    prop.transferOwnership(match);
                }
            }
        }
    }

    public void runReciprocation() {
        mostWantedColoredSet();
    }

    private void mostWantedColoredSet() {
        EnumMap<TileAttribute, Integer> scores = new EnumMap<>(TileAttribute.class);

        for (PropertyTile prop : client.getProperties()) {
            if (prop.getAttributes().contains(TileAttribute.COLORED_PROPERTY)) {
                if (scores.containsKey(prop.getColorSet()))
                    scores.put(prop.getColorSet(), scores.get(prop.getColorSet()) + 1);
                else
                    scores.put(prop.getColorSet(), 1);
            }
        }

        TileAttribute largest = null;

        for (Map.Entry<TileAttribute, Integer> entry : scores.entrySet()) {
            if (largest == null) {
                largest = entry.getKey();
                continue;
            }

            if (scores.get(entry.getKey()) > scores.get(largest))
                largest = entry.getKey();
        }

        mostWantedSet = largest;
    }

    /**
     * @return the client
     */
    public Player getClient() {
        return client;
    }

    /**
     * @return the mostWantedSet
     */
    public TileAttribute getMostWantedSet() {
        return mostWantedSet;
    }

    /**
     * @return the match
     */
    public Player getMatch() {
        return match;
    }

    /**
     * @return the matchBroker
     */
    public TradeBroker getMatchBroker() {
        return matchBroker;
    }

    private void findBestPlayerMatch() {
        List<Player> players = client.getGame().getPlayers();
        HashMap<Player, Integer> scores = new HashMap<>();

        for (Player p : players) {
            int score = 0;
            for (PropertyTile prop : client.getProperties())
                if (prop.getAttributes().contains(mostWantedSet))
                    score++;

            scores.put(p, score);
        }

        Player largest = null;

        for (Player p : players) {
            if (largest == null) {
                largest = p;
                continue;
            }

            if (scores.get(p) > scores.get(largest)) {
                largest = p;
            }
        }

        match = largest;
    }

    private void generateTradeBrokerForMatch() {
        matchBroker = new TradeBroker(match);
        matchBroker.runReciprocation();
    }
}
