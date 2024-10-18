package org.centrale.objet.woe;

import java.util.Random;

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
     * @param nom: nom du loup
     * 
    */
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p,String nom){
        super(pV, dA, pPar, paAtt, paPar, p, nom);
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
                double d = this.pos.distance(c.pos);
        boolean attaque = true;
        Random x = new Random();
        if (d <= 1) {
            int y = x.nextInt(100);
            System.out.println("Rand du tirage aléatoire" + y);
            if (y > this.pageAtt) {
                attaque = false;
            }
            System.out.println("attaque " + attaque);
            if (attaque) {
                int z = x.nextInt(100);
                if (z > c.pagePar) {
                    c.ptVie -= this.degAtt;
                } else {
                    c.ptVie = c.ptVie -this.degAtt + c.ptPar;
                }
            }
        }
    }
}

