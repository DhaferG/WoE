/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Random;

/**
 * la classe Archer sous classe de Personnage définit le personnage Archer
 * @author nourkouki
 * @author dghanmi
 */


public class Archer extends Personnage {
    //Attributs
    /**
     * le nombre de fleches de l'Archer
     */
    public int nbFleches;

    // Constructeurs
    /**
     * 
     * @param n: du personnage
     * @param pV: les points de vie du personnage
     * @param dA: degré d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param dMax: distance maximale d'attaque
     * @param p: position du personnage 
     * @param nbFleches : nombre de fleches
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches) {
        super(pV, dA, pPar, paAtt, paPar, p, n, dMax);
        this.nbFleches = nbFleches;
    }

    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;
        this.pos= new Point2D(a.pos);
    }

    public Archer() {
        super();
    }
    
    
    /** 
     * Methode combattre définit le systeme de combat 
     * @param c : une creature
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
                    c.ptVie = this.degAtt;
                } else {
                    c.ptVie -= (this.ptVie - c.ptPar);
                }
            }
        }
        if ((d < this.distAttMax) && (d > 1)) {
            int y = x.nextInt(100);
            if (y > this.pageAtt) {
                attaque = false;
            }
            if (attaque) {
                this.nbFleches-=1;
                c.ptVie -= this.degAtt;

            }
        }
        if (d >= this.distAttMax) {
            System.out.println("Echec");
        }

    }
}

