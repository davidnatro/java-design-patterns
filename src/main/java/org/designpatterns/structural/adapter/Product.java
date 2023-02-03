package org.designpatterns.structural.adapter;

public final class Product {
    private final String name;

    private final double price;

    public Product(final String name, final double price) {
        this.name = name;
        this.price = price;
    }

    public final String getName() {
        return name;
    }

    public final double getPrice() {
        return price;
    }
}
