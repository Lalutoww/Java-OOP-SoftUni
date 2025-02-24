package loggertask.appenders;

import loggertask.enums.ReportLevel;
import loggertask.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.layout.formatByLayout(date, reportLevel, message));
    }
}
