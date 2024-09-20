package org.centrale.objet.woe;

public class Epee extends Objet{
    public int degAtt;
    public Epee(Point2D pos,int pts,int degAtt) {
        super(pos, pts);
        this.degAtt = degAtt;
    }
}
