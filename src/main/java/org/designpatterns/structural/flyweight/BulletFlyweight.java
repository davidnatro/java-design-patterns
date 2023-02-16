package org.designpatterns.structural.flyweight;

import lombok.Getter;

public class BulletFlyweight {
    @Getter private final Image image;

    @Getter private final Sound sound;

    public BulletFlyweight(final Image image, final Sound sound) {
        this.image = image;
        this.sound = sound;
    }
}

class Image { }
class Sound { }
