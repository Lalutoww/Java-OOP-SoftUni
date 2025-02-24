package loggertask.appenders;

import loggertask.enums.ReportLevel;
import loggertask.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if (this.canAppend(reportLevel)) {
            increaseMessageCount();
            System.out.println(this.layout.formatByLayout(date, reportLevel, message));
        }
    }
}
