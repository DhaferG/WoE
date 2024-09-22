package org.centrale.objet.woe;

/**
 *
 * @author DhaferG
 */

public class Guerrier extends Personnage {
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p, n, dMax);
    }
    
    public Guerrier(Guerrier g) {
        super(g);
        this.pos= new Point2D(g.pos);
    }

    public Guerrier() {
        super();
    }

    public void combattre(){
    }
}
