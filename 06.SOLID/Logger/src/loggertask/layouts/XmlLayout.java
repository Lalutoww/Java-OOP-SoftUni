package loggertask.layouts;

import loggertask.enums.ReportLevel;
import loggertask.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String formatByLayout(String date, ReportLevel reportLevel, String message) {
        return String.format("<log>%n    <date>%s</date>%n    <level>%s</level>%n    <message>%s</message>%n</log>",date, reportLevel, message);
    }

}
