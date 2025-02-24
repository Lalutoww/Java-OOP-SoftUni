package loggertask.appenders;

import loggertask.interfaces.Appender;
import loggertask.interfaces.Layout;

public abstract class BaseAppender implements Appender {
    protected Layout layout;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
    }
}
