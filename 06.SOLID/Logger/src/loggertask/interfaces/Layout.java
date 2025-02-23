package loggertask.interfaces;

import loggertask.enums.ReportLevel;

public interface Layout {
    String formatByLayout(String date, ReportLevel reportLevel, String message);
}
