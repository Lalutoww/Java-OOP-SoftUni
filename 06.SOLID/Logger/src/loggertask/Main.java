package loggertask;

import loggertask.appenders.ConsoleAppender;
import loggertask.interfaces.Appender;
import loggertask.interfaces.Layout;
import loggertask.interfaces.Logger;
import loggertask.layouts.SimpleLayout;
import loggertask.loggers.MessageLogger;

public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        Logger logger = new MessageLogger(consoleAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

    }
}
