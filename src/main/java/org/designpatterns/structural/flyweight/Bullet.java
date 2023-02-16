package org.designpatterns.structural.flyweight;

import lombok.Getter;
import lombok.Setter;

public class Bullet {
    private static int countBullets = 0;

    private final int id = ++countBullets;

    @Getter @Setter private int x;

    @Getter @Setter private int y;

    @Getter private final BulletFlyweight bulletData;

    public Bullet(final BulletFlyweight bulletFlyweight) {
        this.bulletData = bulletFlyweight;
    }

    @Override
    public String toString() {
        return "Bullet" + " #" + id + " {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}