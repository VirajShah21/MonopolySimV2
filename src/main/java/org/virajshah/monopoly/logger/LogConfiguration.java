package org.virajshah.monopoly.logger;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class LogConfiguration {
    public enum LogFormat {
        TEXT, JSON
    }

    static LogFormat format = LogFormat.TEXT;
    static boolean writing = true;
    static boolean writingErrors = true;
    static boolean printing = false;
    static boolean printingErrors = true;
    static List<String> disabledWritingLogs = new ArrayList<>();
    static List<String> disabledPrintingLogs = new ArrayList<>();

    public static LogFormat format() {
        return format;
    }

    public static void format(LogFormat newFormat) {
        format = newFormat;
    }

    public static boolean writing() {
        return writing;
    }

    public static void writing(boolean newWritingValue) {
        writing = newWritingValue;
    }

    public static boolean writingErrors() {
        return writingErrors;
    }

    public static void writingErrors(boolean newWritingErrorsValues) {
        writingErrors = newWritingErrorsValues;
    }

    public static boolean printing() {
        return printing;
    }

    public static void printing(boolean newPrintingValue) {
        printing = newPrintingValue;
    }

    public static boolean printingErrors() {
        return printingErrors;
    }

    public static void printingErrors(boolean newPrintingErrorsValues) {
        printingErrors = newPrintingErrorsValues;
    }

    public static List<String> disabledPrintingLogs() {
        return disabledPrintingLogs;
    }

    public static List<String> disabledWritingLogs() {
        return disabledWritingLogs;
    }

    public static void disablePrintingLogs(String type) {
        if (!disabledPrintingLogs.contains(type))
            disabledPrintingLogs.add(type);
    }

    public static void enablePrintingLogs(String type) {
        if (disabledPrintingLogs.contains(type))
            disabledPrintingLogs.add(type);
    }

    public static void disableWritingLogs(String type) {
        if (!disabledWritingLogs.contains(type))
            disabledWritingLogs.add(type);
    }

    public static void enableWritingLogs(String type) {
        if (disabledWritingLogs.contains(type))
            disabledWritingLogs.add(type);
    }
}
