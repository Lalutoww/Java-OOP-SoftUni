package loggertask.interfaces;

import loggertask.enums.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);
}
