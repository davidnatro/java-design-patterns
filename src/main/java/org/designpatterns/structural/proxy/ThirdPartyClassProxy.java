package org.designpatterns.structural.proxy;

public class ThirdPartyClassProxy implements ThirdPartyLib {
    private final ThirdPartyLib thirdPartyLib;

    private Data cachedData;

    public ThirdPartyClassProxy() {
        this.thirdPartyLib = new ThirdPartyClass();
    }

    @Override
    public Data getData() {
        if (cachedData == null) {
            cachedData = thirdPartyLib.getData();
        }

        return cachedData;
    }
}
