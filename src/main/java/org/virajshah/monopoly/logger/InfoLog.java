package org.virajshah.monopoly.logger;

import org.virajshah.json.Json;

public class InfoLog extends Log {
    private String message;

    public InfoLog(String message) {
        super("InfoLog");
        this.message = message;
    }

    @Override
    public Json toJson() {
        Json out = super.toJson();
        out.put("message", message);
        return out;
    }

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), message);
    }
}
