package loggertask.appenders;

import loggertask.enums.ReportLevel;
import loggertask.interfaces.File;
import loggertask.interfaces.Layout;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, String fileName) {
        this(layout);
        this.file = new LogFile(fileName);
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, ReportLevel reportLevel, String fileName) {
        super(layout, reportLevel);
        this.file = new LogFile(fileName);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if (canAppend(reportLevel)) {
            String output = this.layout.formatByLayout(date, reportLevel, message);
            increaseMessageCount();
            file.append(output);
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
