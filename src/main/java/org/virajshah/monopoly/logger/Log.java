package org.virajshah.monopoly.logger;

import org.virajshah.json.Json;

public abstract class Log {
    protected String type;

    public Log(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Json toJson() {
        Json out = new Json();
        out.put("type", type);
        return out;
    }

    @Override
    public String toString() {
        return type + ":";
    }
}
