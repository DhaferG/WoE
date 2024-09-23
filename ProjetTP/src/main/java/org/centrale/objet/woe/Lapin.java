/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 * Classe Lapin sous classe de Monstre définit les caractéristiques d'un Monstre Lapin
 * @author nourkouki
 * @author dghanmi
 */

public class Lapin extends Monstre {
    
    // constructeurs
    /**
     * 
     * @param pV: points de vie
     * @param dA: degré d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param p: position du monstre 
     */
    public Lapin(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    
    }
    /**
     * Constructeur de recopie
     * @param l: un lapin deja existant 
     */
    
    public Lapin(Lapin l){
        super(l);
        this.pos= new Point2D(l.pos);
    }
    /**
     * Constructeur par défaut
     */
    
    public Lapin(){
    
    }
}
