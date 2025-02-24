package loggertask.appenders;

import loggertask.enums.ReportLevel;
import loggertask.interfaces.File;
import loggertask.interfaces.Layout;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        String output = this.layout.formatByLayout(date, reportLevel, message);
        file.append(output);
    }

    public void setFile(File file) {
        this.file = file;
    }
}
