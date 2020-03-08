package org.virajshah.monopoly.logger;

public class ErrorLog extends Log {
    Exception e;

    public ErrorLog(String message) {
        super(message);
    }

    public ErrorLog(String message, Exception e) {
        super(message);
        this.e = e;
    }

    public Exception getException() {
        return e;
    }
}
