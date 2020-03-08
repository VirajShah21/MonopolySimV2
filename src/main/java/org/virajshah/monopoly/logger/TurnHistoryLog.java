package org.virajshah.monopoly.logger;

import org.virajshah.json.Json;
import org.virajshah.monopoly.beans.TurnHistoryBean;

public class TurnHistoryLog extends Log {
    TurnHistoryBean turn;

    public TurnHistoryLog(TurnHistoryBean turn) {
        super("TurnHistoryLog");
        this.turn = turn;
    }

    @Override
    public Json toJson() {
        Json out = new Json();
        out.put("turnNumber", turn.getTurnNumber());
        out.put("diceRoll1", turn.getDiceRoll1());
        out.put("diceRoll2", turn.getDiceRoll2());
        out.put("origin", turn.getOrigin());
        out.put("destination", turn.getDestination());
        out.put("originInJail", turn.isOriginInJail());
        out.put("destinationInJail", turn.isDestinationInJail());
        out.put("initialBalance", turn.getInitialBalance());
        out.put("recentBalance", turn.getRecentBalance());
        out.put("newProperties", turn.getNewProperties().toString());
        out.put("lostProperties", turn.getLostProperties());
        return out;
    }

    @Override
    public String toString() {
        return "Turn History:\n" + toJson();
    }
}
