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
    
    public void combattre(Creature c){
    }
}

