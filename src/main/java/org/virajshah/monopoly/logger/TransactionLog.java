package org.virajshah.monopoly.logger;

import org.virajshah.monopoly.core.Player;

public class TransactionLog extends Log {
    protected Player sender;
    protected Player receiver;
    protected int amount;

    public TransactionLog(Player sender, Player receiver, int amount) {
        super("TransactionLog");
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s %s is paying %s $%d", super.toString(), sender.getName(), receiver.getName(), amount);
    }
}
