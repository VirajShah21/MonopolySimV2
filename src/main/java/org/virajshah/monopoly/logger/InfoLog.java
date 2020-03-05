package org.virajshah.monopoly.logger;

public class InfoLog extends Log {
    private String message;

    public InfoLog(String message) {
        super("InfoLog");
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), message);
    }
}
