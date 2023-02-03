package org.designpatterns.structural.facade;

public class FacadeWriter implements Writer {
    private final Writer jsonWriter;
    private final Writer xmlWriter;
    private final Writer fileWriter;

    public FacadeWriter(final String path) {
        this.jsonWriter = new JsonWriter(path);
        this.xmlWriter = new XmlWriter(path);
        this.fileWriter = new FileWriter(path);
    }

    @Override
    public void write() {
        jsonWriter.write();
        xmlWriter.write();
        fileWriter.write();
    }
}
