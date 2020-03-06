package org.virajshah.monopoly.logger;

@SuppressWarnings("unused")
public class LogConfiguration {
    public enum LogFormat {
        TEXT, JSON
    }

    static LogFormat format;
    static boolean writing;
    static boolean writingErrors;
    static boolean printing;
    static boolean printingErrors;

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
}
