package org.virajshah.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class Json extends HashMap<String, Object> {
    public Json() {
        super();
    }

    public Json(String key, Json value) {
        super();
        put(key, value);
        put(key, value);
    }

    public Json(String key, String value) {
        put(key, value);
    }

    public Json(String key, Integer value) {
        put(key, value);
    }

    public Json(String key, Double value) {
        put(key, value);
    }

    public Json(String key, Long value) {
        put(key, value);
    }

    public Json(String key, Float value) {
        put(key, value);
    }

    public Json(String key, Boolean value) {
        put(key, value);
    }

    public Json(String key, Character value) {
        put(key, value + "");
    }

    public String toString() {
        StringBuilder out = new StringBuilder("{");
        int entriesEvaluated = 0;

        for (Map.Entry<String, Object> child : entrySet()) {
            entriesEvaluated++;

            out.append(String.format("\"%s\": ", child.getKey()));

            if (child.getValue() instanceof String)
                out.append(String.format("\"%s\"", child.getValue()));
            else if (child.getValue() instanceof Number)
                out.append(child.getValue().toString());
            else if (child.getValue() instanceof List)
                out.append(child.getValue().toString());
            else
                out.append(child.getValue().toString());

            if (entriesEvaluated != size()) {
                out.append(",\n");
            } else {
                out.append("\n}");
            }
        }

        return out.toString();
    }
}
