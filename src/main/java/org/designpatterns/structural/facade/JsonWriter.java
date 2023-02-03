package org.designpatterns.structural.facade;

public class JsonWriter implements Writer {
    private final String path;

    public JsonWriter(final String path) {
        this.path = path + ".json";
    }

    @Override
    public final void write() {
        System.out.println("Writing to JSON..." + " path: " + path);
    }
}
