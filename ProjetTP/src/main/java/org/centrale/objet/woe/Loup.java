package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 * @author dghanmi
 */
public class Loup extends Monstre {
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    }
    
    public Loup(Loup l) {
        super(l);
        this.pos= new Point2D(l.pos);
    }

    public Loup() {
        super();
    }

    
    /** 
     * @param c
     */
    public void combattre(Creature c){
    }
}
