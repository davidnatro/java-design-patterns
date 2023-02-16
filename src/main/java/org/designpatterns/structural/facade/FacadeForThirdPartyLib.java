package org.designpatterns.structural.facade;

public class FacadeForThirdPartyLib {
    private final ThirdPartyLib thirdPartyLib;

    public FacadeForThirdPartyLib() {
        this.thirdPartyLib = new ThirdPartyLib();
    }

    public void method2() {
        System.out.println(thirdPartyLib.method2());
    }

    public void method3() {
        System.out.println(thirdPartyLib.method3());
    }
}
