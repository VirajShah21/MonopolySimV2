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

    private static String refactorStringValue(String in) {
        while (in.contains("\n"))
            in = in.replace("\n", "\\n");

        while (in.contains("\t"))
            in = in.replace("\t", "\\t");

        return in;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        int entriesEvaluated = 0;

        for (Map.Entry<String, Object> child : entrySet()) {
            entriesEvaluated++;

            out.append(String.format("\"%s\": ", child.getKey()));

            if (child.getValue() instanceof String)
                out.append(String.format("\"%s\"", refactorStringValue((String) child.getValue())));
            else if (child.getValue() instanceof Number)
                out.append(refactorStringValue(child.getValue().toString()));
            else if (child.getValue() instanceof List)
                out.append(refactorStringValue(child.getValue().toString()));
            else
                out.append(refactorStringValue(child.getValue().toString()));

            if (entriesEvaluated != size()) {
                out.append(",\n");
            } else {
                out.append("\n}");
            }
        }

        return out.toString();
    }
}
