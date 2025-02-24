package loggertask.appenders;

import loggertask.enums.ReportLevel;
import loggertask.interfaces.Appender;
import loggertask.interfaces.Layout;

public abstract class BaseAppender implements Appender {
    private static final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    protected Layout layout;
    private ReportLevel reportLevel;
    private int messagesCount;

    protected BaseAppender(Layout layout) {
        this(layout, DEFAULT_REPORT_LEVEL);
    }

    protected BaseAppender(Layout layout, ReportLevel reportLevel) {
        this.layout = layout;
        this.reportLevel = reportLevel;
        this.messagesCount = 0;
    }

    public boolean canAppend(ReportLevel reportLevelToCheck) {
        return this.reportLevel.ordinal() <= reportLevelToCheck.ordinal();
    }

    public void SetReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public void increaseMessageCount() {
        this.messagesCount++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(), this.reportLevel, messagesCount);
    }
}
