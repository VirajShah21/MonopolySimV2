package org.virajshah.monopoly.logger;

import org.virajshah.monopoly.logger.LogConfiguration.LogFormat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Logger {
    private static final String TEXT_LOG_FORMAT = "* [%s]:%s - %s";

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
        long runtimeId = generateRuntimeId();
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

        if (isLogAllowedForPrinting(nextLog) && LogConfiguration.format() == LogFormat.TEXT) {
            if (LogConfiguration.printing())
                System.out.println(String.format(TEXT_LOG_FORMAT, timeStamp, className, nextLog.toString()));

            if (nextLog instanceof ErrorLog && LogConfiguration.printingErrors() && ((ErrorLog) nextLog).getException() != null)
                for (StackTraceElement element : ((ErrorLog) nextLog).getException().getStackTrace())
                    System.out.println(String.format(TEXT_LOG_FORMAT, timeStamp, className, element.toString()));
        }
    }

    private static boolean isLogAllowedForWriting(Log tmp) {
        for (String type : LogConfiguration.disabledWritingLogs())
            if (tmp.getType().equals(type))
                return false;
        return true;
    }

    private static boolean isLogAllowedForPrinting(Log tmp) {
        for (String type : LogConfiguration.disabledPrintingLogs())
            if (tmp.getType().equals(type))
                return false;
        return true;
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
        StringBuilder out = new StringBuilder("[");
        if (LogConfiguration.format() == LogFormat.JSON) {
            int processed = 0;
            int total = logs.size();

            for (Log log : logs) {
                if (!LogConfiguration.disabledWritingLogs().contains(log.getType()))
                    out.append(log.toJson());

                processed++;

                if (processed != total)
                    out.append(",\n");
            }
            out.append("\n]");
            writer.println(out.toString());
        }

        writer.close();
    }
}
