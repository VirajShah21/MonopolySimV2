package org.virajshah.monopoly.simulator;

import org.virajshah.monopoly.logger.Json;

public class JsonTester {
    public static void main(String[] args) {
        Json data = new Json();
        Json dob = new Json();
        dob.put("year", 1999);
        dob.put("month", 12);
        dob.put("day", 21);

        data.put("name", "Viraj Shah");
        data.put("dob", dob);
        data.put("color", "brown");
        System.out.println(data.toString());
    }
}
