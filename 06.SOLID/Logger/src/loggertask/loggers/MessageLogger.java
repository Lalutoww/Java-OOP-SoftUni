package loggertask.loggers;

import loggertask.enums.ReportLevel;
import loggertask.interfaces.Appender;
import loggertask.interfaces.Logger;

import java.util.Arrays;

public class MessageLogger implements Logger {
    Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String date, String message) {
        log(date, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String date, String message) {
        log(date, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String date, String message) {
        log(date, ReportLevel.ERROR, message);

    }

    @Override
    public void logCritical(String date, String message) {
        log(date, ReportLevel.CRITICAL, message);

    }

    @Override
    public void logFatal(String date, String message) {
        log(date, ReportLevel.FATAL, message);
    }

    private void log(String date, ReportLevel reportLevel, String message) {
        Arrays.stream(this.appenders).forEach(a -> a.append(date, reportLevel, message));
    }
}
