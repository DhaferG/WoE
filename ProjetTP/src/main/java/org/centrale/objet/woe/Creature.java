/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.sql.Connection;

/**
 * la classe Creature permet de gérer les créatures
 * @author nourkouki
 * @author dghanmi
 */
public abstract class Creature extends ElementDeJeu implements Deplacable{
    //Attributs de la classe
    /**
     * Points de Vie du monstre
     */
    public int ptVie;
    
    /**
     * Degats d'attaque
     */
    public int degAtt;
    
    /**
     * Points de parade
     */
    public int ptPar;
    
    /**
     * pourcentage d'attaque
     */
    public int pageAtt;
    
    /**
     * pourcentage de parade
     */
    public int pagePar;
    
    /**
     * position
     */

    // constructeurs
    /**
     * Constructeur de la classe Creature avec 6 parametres
     * @param pV: points de vie
     * @param dA: degré d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param p: position du monstre 
     */
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(p);
        this.ptVie= pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
    }
    /**
     * Constructeur de recopie de la classe creature
     * @param c : une creature déja existante
     */
    
    public Creature(Creature c){
        super(c);
        this.ptVie=c.ptVie;
        this.degAtt=c.degAtt;
        this.ptPar=c.ptPar;
        this.pageAtt=c.pageAtt;
        this.pagePar=c.pagePar;
    }
    
    /**
     * constructeur par defaut de la classe Creature
     */
    
    public Creature(){
        super();
    }
    public void deplace(){

    }
    
    
}
