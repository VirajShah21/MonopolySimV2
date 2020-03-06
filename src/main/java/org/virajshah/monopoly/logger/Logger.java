package org.virajshah.monopoly.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings("unused")
public class Logger {
    private static final String LOG_FORMAT = "* [%s]:%s - %s";

    private static long runtimeId;

    private String className;
    private static List<Log> logs;
    private static PrintWriter writer;

    @SuppressWarnings("rawtypes")
    public Logger(Class className) {
        if (writer == null)
            throw new NullPointerException("Logger.init() must be called before call to constructor to initialize constructor");
        this.className = className.getName();
    }

    public static void init() {
        logs = new ArrayList<>();
        runtimeId = generateRuntimeId();
        try {
            writer = new PrintWriter(String.format("logs/RuntimeLog$%s.log", runtimeId), "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new LoggerException("Could not initialize the file writer!");
        }
    }

    public List<Log> getLogs() {
        return logs;
    }

    @SuppressWarnings("java:S106")
    public void log(Log nextLog) {
        String timeStamp = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        logs.add(nextLog);

        if (LogConfiguration.printing())
            System.out.println(String.format(LOG_FORMAT, timeStamp, className, nextLog.toString()));

        if (nextLog instanceof ErrorLog && LogConfiguration.printingErrors() && ((ErrorLog) nextLog).getException() != null)
            for (StackTraceElement element : ((ErrorLog) nextLog).getException().getStackTrace())
                System.out.println(String.format(LOG_FORMAT, timeStamp, className, element.toString()));

        if (LogConfiguration.writing() && LogConfiguration.format() == LogConfiguration.LogFormat.TEXT)
            writer.println(String.format(LOG_FORMAT, timeStamp, className, nextLog.toString()));

        if (nextLog instanceof ErrorLog && LogConfiguration.writingErrors() && ((ErrorLog) nextLog).getException() != null)
            for (StackTraceElement element : ((ErrorLog) nextLog).getException().getStackTrace())
                writer.println(String.format(LOG_FORMAT, timeStamp, className, element.toString()));

    }

    private static long generateRuntimeId() {
        File logsDir = new File("logs");
        String[] logs = logsDir.list();
        long greatest = 100000;
        long num;

        if (logs != null) {
            for (String log : logs) {
                try {
                    num = Long.parseLong(log.substring(log.indexOf('$') + 1, log.indexOf(".log")));
                } catch (StringIndexOutOfBoundsException e) {
                    continue;
                }

                if (num > greatest)
                    greatest = num;
            }
        }

        return greatest + 1;
    }

    public static void save() {
        if (logs.size() == 1 && logs.get(0) instanceof JsonLog)
            writer.println(logs.get(0).toString());

        writer.close();
    }

    public long getRuntimeId() {
        return runtimeId;
    }
}
