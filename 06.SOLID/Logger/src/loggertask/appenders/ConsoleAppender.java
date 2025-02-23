package loggertask.appenders;

import loggertask.enums.ReportLevel;
import loggertask.interfaces.Appender;
import loggertask.interfaces.Layout;

public class ConsoleAppender implements Appender {
    Layout layout;
    
    public ConsoleAppender(Layout layout) {
        this.layout = layout;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(layout.formatByLayout(date, reportLevel, message));
    }
}
