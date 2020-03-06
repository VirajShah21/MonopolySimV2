package org.virajshah.monopoly.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

// Todo: Also use the LogConfiguration
public class Logger {
    private static long runtimeId;
    private static Random random;

    private String className;
    private static List<Log> logs;
    private static PrintWriter writer;

    public Logger(Class className) {
        if (writer == null)
            throw new NullPointerException("Logger.init() must be called before call to constructor to initialize constructor");
        this.className = className.getName();
    }

    public static void init() {
        logs = new ArrayList<>();
        random = new Random();
        runtimeId = generateRuntimeId();
        try {
            writer = new PrintWriter(String.format("logs/RuntimeLog$%s.log", runtimeId), "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new RuntimeException("Could not initialize the file writer!");
        }
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void log(Log nextLog) {
        String timeStamp = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        logs.add(nextLog);

        if (LogConfiguration.printing()) {
            System.out.println(String.format("* [%s]:%s - %20s", timeStamp, className, nextLog.toString()));
        }

        if (LogConfiguration.writing()) {
            if (LogConfiguration.format() == LogConfiguration.LogFormat.TEXT)
                writer.println(String.format("* [%s]:%s - %20s", timeStamp, className, nextLog.toString()));
        }
    }

    private static long generateRuntimeId() {
        File logsDir = new File("logs");
        String[] logs = logsDir.list();
        long greatest = 100000;
        long num = 0;

        for (String log : logs) {
            try {
                num = Long.parseLong(log.substring(log.indexOf("$") + 1, log.indexOf(".log")));
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            }

            if (num > greatest)
                greatest = num;
        }

        return greatest + 1;
    }

    private static boolean save() {
        if (logs.size() == 1 && logs.get(0) instanceof JsonLog) {
            writer.println(logs.get(0).toString());
        }
        writer.close();
        return true;
    }
}
