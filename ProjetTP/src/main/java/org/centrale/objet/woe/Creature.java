/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

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
     * position du monstre
     */
    //public Point2D pos;

    // constructeurs
    /**
     * Constructeur de la classe Creature avec 6 parametres
     * @param pV: points de vie
     * @param dA: degré d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param p: position du monstre 
     * @param nom: nom de la creature
     */
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, String nom){
        super(p);
        this.setNom(nom);
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
        super();
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
    public void deplace(World w, int dx , int dy){
        int x = this.pos.getX();
        int y = this.pos.getY();
        int h = w.getTailleMonde();
        if ((x+dx<h) &&(x+dx>=0)&& (y+dy>=0)&&(y+dy<h)){
            if (!(w.inposition(x+dx, y+dy) instanceof Creature)){
                this.setPos(new Point2D(x+dx,y+dy));
            }
        }
        else{
            this.setPos(new Point2D(x,y));
        }
    }    
}
