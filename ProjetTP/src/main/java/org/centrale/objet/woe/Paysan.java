/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 * @author dghanmi
 */
public class Paysan extends Personnage {

    // Constructeurs
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p, n, dMax);
    }

    public Paysan(Paysan p) {
        super(p);
        this.pos= new Point2D(p.pos);
    }

    public Paysan() {
        super();
    }
}
