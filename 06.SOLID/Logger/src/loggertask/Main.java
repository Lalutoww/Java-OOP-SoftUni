package loggertask;

import loggertask.appenders.ConsoleAppender;
import loggertask.interfaces.Appender;
import loggertask.interfaces.Layout;
import loggertask.interfaces.Logger;
import loggertask.layouts.XmlLayout;
import loggertask.loggers.MessageLogger;

public class Main {
    public static void main(String[] args) {
        Layout xmlLayout = new XmlLayout();
        Appender consoleAppender = new ConsoleAppender(xmlLayout);
        Logger logger = new MessageLogger(consoleAppender);

        logger.logFatal("3/31/2015 5:23:54 PM", "mscorlib.dll does not respond");
        logger.logCritical("3/31/2015 5:23:54 PM", "No connection string found in App.config");
    }
}
