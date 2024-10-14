package org.centrale.objet.woe;

/**
 * sous classe de Monstre gérant les Loups
 * @author nourkouki
 * @author dghanmi
 */
public class Loup extends Monstre implements Combattant {
    // constructeurs
    /**
     * Un constructeur de la classe Monstre avec 6 parametres
     * @param pV: points de vie
     * @param dA: degats d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param p: position du monstre 
     * 
    */
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    }
     /**
     * Constructeur de recopie de la classe Loup
     * permet de creer un monstre à partir d'un autre loup existant
     * prend un seul parametre
     * @param l: un loup exitant
     */
    public Loup(Loup l) {
        super(l);
        this.pos= new Point2D(l.pos);
    }

    public Loup() {
        super();
    }

    
    /** 
     * @param c: Creature à combattre
     */
    public void combattre(Creature c){
    }
}
