package loggertask.layouts;

import loggertask.enums.ReportLevel;
import loggertask.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String formatByLayout(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel, message);
    }
}
