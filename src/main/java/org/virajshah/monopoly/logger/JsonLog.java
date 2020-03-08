package org.virajshah.monopoly.logger;

import org.virajshah.json.Json;

public class JsonLog extends Log {
    Json log;

    public JsonLog(Json log) {
        super("JsonLog");
        this.log = log;
    }
}
