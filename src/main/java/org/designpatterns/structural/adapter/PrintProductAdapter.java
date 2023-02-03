package org.designpatterns.structural.adapter;

public class PrintProductAdapter {
    private final Product product;

    private static final String nameField = "Name: ";

    private static final String priceField = "Price: ";

    public PrintProductAdapter(final Product product) {
        this.product = product;
    }

    public void print() {
        StringBuilder result = new StringBuilder();

        result.append(nameField).append(product.getName()).append(" ; ");
        result.append(priceField).append(product.getPrice());

        System.out.println(result);
    }
}
