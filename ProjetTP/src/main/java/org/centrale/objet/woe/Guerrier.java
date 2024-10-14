package org.centrale.objet.woe;

import java.util.Random;

/**
 * sous classe de personnage gérant les guerriers
 * @author nourkouki
 * @author dghanmi
 */

public class Guerrier extends Personnage implements Combattant {
    // Constructeurs
    /**
     * Un constructeur de la classe Guerrier avec 8 parametres
     * @param n: nom du personnage
     * @param pV: les points de vie du personnage
     * @param dA: degats d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param dMax: distance maximale d'attaque
     * @param p: position du personnage 
     * 
    */
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p, n, dMax);
    }
     /**
     * Un constructeur de recopie de la classe Guerrier
     * permet de creer un personnage à partir d'un autre guerrier existant
     * @param g: un personnage guerrier
     */
    public Guerrier(Guerrier g) {
        super(g);
        this.pos= new Point2D(g.pos);
    }

    public Guerrier() {
        super();
    }

    
    /** 
     * Methode combattre permettant Guerrier de combattre des créatures c
     * @param c: créature à combattre
     */
    public void combattre(Creature c){
        double d = this.pos.distance(c.pos);
        boolean attaque = true;
        Random x = new Random();
        if (d == 1) {
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
