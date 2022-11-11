package org.designpatterns.lazy_initialization;

import java.util.ArrayList;
import java.util.List;

public class LazyObject {
    private final StringBuilder result = new StringBuilder();
    private final List<Integer> data = new ArrayList<Integer>(10);

    public LazyObject() {
        for (int i = 0; i < 10; i++) {
            data.add(i + 1);
            result.append(i + 1);
            result.append(" ");
        }
    }

    public void lazy() {
        for (final Integer element : data) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public void notLazy() {
        System.out.println(result);
    }
}
