/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 */
public class Archer extends Personnage {
    private int nbFleches;

    // Constructeurs
    public Archer(String n, int pVie, int dAtt, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches) {
        super(n, pVie, dAtt, pPar, paAtt, paPar, dMax, p);
        this.nbFleches = nbFleches;
    }

    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;
    }

    public Archer() {
        super();
        this.nbFleches = 0;
    }
}

