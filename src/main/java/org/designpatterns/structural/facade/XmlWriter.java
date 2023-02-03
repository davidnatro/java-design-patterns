package org.designpatterns.structural.facade;

public class XmlWriter implements Writer {
    private final String path;

    public XmlWriter(final String path) {
        this.path = path + ".xml";
    }

    @Override
    public final void write() {
        System.out.println("Writing to XML..." + " path: " + path);
    }
}
