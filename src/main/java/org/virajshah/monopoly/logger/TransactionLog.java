package org.virajshah.monopoly.logger;

import org.virajshah.json.Json;
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

    public Json toJson() {
        Json out = super.toJson();
        out.put("sender", sender.getName());
        out.put("receiver", receiver.getName());
        out.put("amount", amount);
        return out;
    }

    @Override
    public String toString() {
        return String.format("%s %s is paying %s $%d", super.toString(), sender.getName(), receiver.getName(), amount);
    }
}
