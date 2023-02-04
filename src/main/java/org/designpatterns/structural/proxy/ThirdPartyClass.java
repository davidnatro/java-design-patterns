package org.designpatterns.structural.proxy;

public class ThirdPartyClass implements ThirdPartyLib {
    @Override
    public Data getData() {
        return new Data();
    }
}
