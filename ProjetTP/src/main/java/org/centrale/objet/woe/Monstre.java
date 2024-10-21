/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 * Classe monstre sous classe de Creature permet d'attribuer des caractéristiques à un monstre
 * @author nourkouki
 * @author dghanmi
 */
public abstract class Monstre extends Creature {
    
    // constructeurs
    /**
     * Un constructeur de la classe Monstre avec 6 parametres
     * @param pV: points de vie
     * @param dA: degats d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param p: position du monstre 
     * @param nom: nom du monstre
     * 
    */
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p,String nom) {
        super(pV, dA, pPar, paAtt, paPar, p, nom);
    }
    
    /**
     * Constructeur de recopie de la classe Monstre
     * permet de creer un monstre à partir d'un autre monstre existant
     * prend un seul parametre
     * @param m: un monstre exitant
     */
    
    public Monstre(Monstre m) {
        super(m);
        
    }
    
    /**
     * Constructeur par défaut de la classe Monstre
     * permet de creer un monstre avec des valeurs par defaut
     */
    
    public Monstre(){
        super();
    }
    
    // Accesseurs et modificateurs
    /** 
     * retourne les points de vie
     * @return le nombre de points de Vie
     */
    public int getPtVie(){
        return ptVie;
    }
    
    /**
     * retourne le degré d'attaque
     * @return le degré d'attaque
     */
    public int getDegAtt() {
        return degAtt;
    }
    
    /**
     * retourne les points de parade
     * @return les points de parade
     */
    public int getPtPar() {
        return ptPar;
    }
    
    /**
     * retourne le pourcentage d'attaque
     * @return  le pourcentage d'attaque
     */
    public int getPageAtt() {
        return pageAtt;
    }
    
    /**
     * retourne le pourcentage de parade
     * @return  le pourcentage de parade
     */
    public int getPagePar() {
        return pagePar;
    }
    
    /**
     * retourne la position
     * @return la position du personnage
     */
    public Point2D getPos() {
        return pos;
    }
    
     /**
     * modifie les points de vie
     * @param ptVie: points de vie
     */
    public void setPtVie(int ptVie){
        this.ptVie=ptVie;
    
    }
    
    /**
     * modifie le degré d'attaque
     * @param degAtt: degré d'attaque
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    
    /**
     * modifie les points de parade
     * @param ptPar: points de parade
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }
    
    /**
     * modifie le pourcentage d'attaque
     * @param pageAtt: pourcentage d'attaque
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }
    
    /**
     * modifie le pourcentage de parade
     * @param pagePar: pourcentage de parade
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }
    
    /**
     * modifie la position
     * @param pos: position
     */

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    // methode affiche
    /**
     * methode affiche permet d'afficher les attributs d'un monstre
     */
    
    public void affiche() {
    System.out.println("Points de vie : " + ptVie);
    System.out.println("Dégâts d'attaque : " + degAtt);
    System.out.println("Points de parade : " + ptPar);
    System.out.println("Pourcentage d'attaque : " + pageAtt);
    System.out.println("Pourcentage de parade : " + pagePar);
    System.out.print("Position : ");
    pos.afficher();
    } 
}
