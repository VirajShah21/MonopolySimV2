package org.virajshah.monopoly.logger;

import org.virajshah.monopoly.core.Player;
import org.virajshah.monopoly.tiles.PropertyTile;

public class RentTransactionLog extends TransactionLog {
    protected PropertyTile property;

    public RentTransactionLog(Player sender, Player receiver, int amount, PropertyTile property) {
        super(sender, receiver, amount);
        this.property = property;
    }

    public PropertyTile getProperty() {
        return property;
    }

    @Override
    public String toString() {
        return String.format("%s for rent on %s", super.toString(), property.getName());
    }
}
