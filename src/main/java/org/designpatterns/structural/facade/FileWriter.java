package org.designpatterns.structural.facade;

public class FileWriter implements Writer {
    private final String path;

    public FileWriter(final String path) {
        this.path = path + ".txt";
    }

    @Override
    public final void write() {
        System.out.println("Writing to file..." + " path: " + path);
    }
}
