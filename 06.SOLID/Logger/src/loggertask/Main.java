package loggertask;

import loggertask.appenders.ConsoleAppender;
import loggertask.appenders.FileAppender;
import loggertask.enums.ReportLevel;
import loggertask.interfaces.Appender;
import loggertask.interfaces.Layout;
import loggertask.interfaces.Logger;
import loggertask.layouts.SimpleLayout;
import loggertask.layouts.XmlLayout;
import loggertask.loggers.MessageLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Appender> appenders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] appenderInfo = sc.nextLine().split("\\s+");

            Appender appender = getAppender(appenderInfo);
            appenders.add(appender);
        }

        String input = sc.nextLine();

        Logger logger = new MessageLogger(appenders.toArray(Appender[]::new));

        while (!input.equals("END")) {
            logMessage(input, logger);

            input = sc.nextLine();
        }

        System.out.println(logger);
    }

    private static void logMessage(String input, Logger logger) {
        String[] logData = input.split("\\|");
        String reportLevel = logData[0];
        String date = logData[1];
        String message = logData[2];

        switch (reportLevel) {
            case "INFO" -> logger.logInfo(date, message);
            case "WARNING" -> logger.logWarning(date, message);
            case "ERROR" -> logger.logError(date, message);
            case "CRITICAL" -> logger.logCritical(date, message);
            case "FATAL" -> logger.logFatal(date, message);
            default -> throw new IllegalArgumentException("Invalid report level argument");
        }
    }

    private static Appender getAppender(String[] appenderInfo) {
        String type = appenderInfo[0];
        String layoutType = appenderInfo[1];

        Layout layout;
        switch (layoutType) {
            case "SimpleLayout" -> layout = new SimpleLayout();
            case "XmlLayout" -> layout = new XmlLayout();
            default -> throw new IllegalArgumentException("Invalid layout!");
        }

        Appender appender;
        switch (type) {
            case "ConsoleAppender" -> {
                if (appenderInfo.length >= 3) {
                    ReportLevel reportLevel = ReportLevel.valueOf(appenderInfo[2]);
                    appender = new ConsoleAppender(layout, reportLevel);
                } else {
                    appender = new ConsoleAppender(layout);
                }
            }
            case "FileAppender" -> {
                if (appenderInfo.length >= 3) {
                    ReportLevel reportLevel = ReportLevel.valueOf(appenderInfo[2]);
                    appender = new FileAppender(layout, reportLevel);
                } else {
                    appender = new FileAppender(layout);
                }
            }
            default -> throw new IllegalArgumentException("Invalid appender type!");
        }
        return appender;
    }
}
