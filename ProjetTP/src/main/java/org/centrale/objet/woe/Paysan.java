/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 * Classe Paysan sous classe de Personnage définit les caractéristiques d'un Paysan
 * @author nourkouki
 * @author dghanmi
 */
public class Paysan extends Personnage {

    // Constructeurs
    /**
     * 
     * @param n: nom du personnage
     * @param pV: les points de vie du personnage
     * @param dA: degré d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param dMax: distance maximale d'attaque
     * @param p: position du personnage 
     *
     */
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p, n, dMax);
    }
    /**
     * Constructeur de recopie
     * @param p : un paysan déja existant
     */

    public Paysan(Paysan p) {
        super(p);
        this.pos= new Point2D(p.pos);
    }
    
    /**
     * Constructeur par defaut
     */
    public Paysan() {
        super();
    }
}
