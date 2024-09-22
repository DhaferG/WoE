/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 */
public class Creature {
    //Attributs de la classe
    /**
     * Points de Vie du monstre
     */
    public int ptVie;
    
    /**
     * Degré d'attaque
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
     * position du monstre
     */
    public Point2D pos;

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
        ptVie= pV;
        degAtt = dA;
        ptPar = pPar;
        pageAtt = paAtt;
        pagePar = paPar;
        pos = p;
    }
    /**
     * Constructeur de recopie de la classe creature
     * @param c : une creature déja existante
     */
    
    public Creature(Creature c){
        this.ptVie=c.ptVie;
        this.degAtt=c.degAtt;
        this.ptPar=c.ptPar;
        this.pageAtt=c.pageAtt;
        this.pagePar=c.pagePar;
        this.pos= new Point2D(c.pos);
    }
    
    /**
     * constructeur par defaut de la classe Creature
     */
    
    public Creature(){
        this.pos= new Point2D();
    }

    
}
