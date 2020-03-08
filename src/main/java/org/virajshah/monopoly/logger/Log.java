package org.virajshah.monopoly.logger;

public abstract class Log {
    protected String logType;

    public Log(String logType) {
        this.logType = logType;
    }

    public String getLogType() {
        return logType;
    }

    @Override
    public String toString() {
        return logType + ":";
    }
}
