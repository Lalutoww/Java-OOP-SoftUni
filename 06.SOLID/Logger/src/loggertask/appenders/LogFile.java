package loggertask.appenders;

import loggertask.interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {
    private static final String DEFAULT_FILE_NAME = "default.txt";

    private StringBuilder text;
    private String fileName;
    private int size;

    public LogFile() {
        this(DEFAULT_FILE_NAME);
    }

    public LogFile(String fileName) {
        this.text = new StringBuilder();
        this.fileName = fileName;
        this.size = 0;
    }

    @Override
    public boolean write(String text) {
        try {
            Files.write(Paths.get(this.fileName), text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void append(String text) {
        text = text + System.lineSeparator();

        this.text.append(text);
        this.write(text);
    }

    @Override
    public int getSize() {
        return this.calculateFileSize();
    }

    private int calculateFileSize() {
        this.size = 0;

        for (Character character : text.toString().toCharArray()) {
            size += character;
        }

        return this.size;
    }

}
