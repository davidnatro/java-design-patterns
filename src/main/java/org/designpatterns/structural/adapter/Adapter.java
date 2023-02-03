package org.designpatterns.structural.adapter;

public class Adapter {
    private final XmlReader xmlReader;

    private final JsonWriter jsonWriter;

    public Adapter(final XmlReader xmlReader, final JsonWriter jsonWriter) {
        this.xmlReader = xmlReader;
        this.jsonWriter = jsonWriter;
    }

    public void adapt() {
        jsonWriter.write(xmlReader.read());
    }
}
