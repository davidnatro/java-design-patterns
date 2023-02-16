package org.designpatterns.structural.flyweight;

public class BulletFactory {
    private final BulletFlyweight bulletFlyweight;

    public BulletFactory() {
        Image image = new Image();
        Sound sound = new Sound();

        this.bulletFlyweight = new BulletFlyweight(image, sound);
    }

    public Bullet getBullet() {
        return new Bullet(bulletFlyweight);
    }
}
