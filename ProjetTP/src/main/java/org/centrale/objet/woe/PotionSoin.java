package org.centrale.objet.woe;

public class PotionSoin extends Objet{
    public int health;
    public PotionSoin(Point2D pos,int pts,int health) {
        super(pos, pts);
        this.health = health;
    }
}
