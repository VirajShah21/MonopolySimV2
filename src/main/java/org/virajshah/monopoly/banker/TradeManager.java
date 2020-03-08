package org.virajshah.monopoly.banker;

import org.virajshah.monopoly.core.Player;
import org.virajshah.monopoly.tiles.PropertyTile;
import org.virajshah.monopoly.tiles.TileAttribute;

import java.util.Map;

public class TradeManager {
    public static void runBestTrade(Player client) {
        TradeBroker broker = new TradeBroker(client);

        Player otherPlayer = broker.getBestTraderMatch();
        TradeBroker otherBroker = new TradeBroker(otherPlayer);

        TradeDeal deal = new TradeDeal(client, otherPlayer);

        TileAttribute receiving = broker.getMostWantedSet();
        TileAttribute giving = otherBroker.getMostWantedSet();

        for (PropertyTile prop : otherPlayer.getProperties())
            if (prop.getAttributes().contains(receiving))
                deal.getPlayer1acquisitions().add(prop);

        for (PropertyTile prop : client.getProperties())
            if (prop.getAttributes().contains(giving))
                deal.getPlayer2acquisitions().add(prop);

        int player1value = 0;
        int player2value = 0;

        Map<PropertyTile, Integer> values = broker.assignPropertyValues();
        for (PropertyTile prop : deal.getPlayer2acquisitions())
            player1value += values.get(prop);

        values = otherBroker.assignPropertyValues();
        for (PropertyTile prop : deal.getPlayer1acquisitions())
            player2value += values.get(prop);

        deal.setCompensation(player2value - player1value);
        
        deal.execute();
    }
}
