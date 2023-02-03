package org.designpatterns.structural.adapter;

public class PrintMovableAdapter {
    private final Movable movable;

    public PrintMovableAdapter(final Movable movable) {
        this.movable = movable;
    }

    public final void print() {
        System.out.println(movable.move());
    }
}
