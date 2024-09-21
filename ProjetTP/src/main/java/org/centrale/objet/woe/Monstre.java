/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Random;

/**
 * Classe monstre permet d'attribuer des caractéristiques à un monstre
 * @author nourkouki
 */
public class Monstre {
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
     * Un constructeur de la classe Monstre avec 6 parametres
     * @param pV: points de vie
     * @param dA: degré d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param p: position du monstre 
     * 
    */
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        ptVie= pV;
        degAtt = dA;
        ptPar = pPar;
        pageAtt = paAtt;
        pagePar = paPar;
        pos = p;
    }
    
    /**
     * Constructeur de recopie de la classe Monstre
     * permet de creer un monstre à partir d'un autre monstre existant
     * prend un seul parametre
     * @param m: un monstre exitant
     */
    
    public Monstre(Monstre m) {
        this.ptVie=m.ptVie;
        this.degAtt=m.degAtt;
        this.ptPar=m.ptPar;
        this.pageAtt=m.pageAtt;
        this.pagePar=m.pagePar;
        this.pos=m.pos;
        
    }
    
    /**
     * Constructeur par défaut de la classe Monstre
     * permet de creer un monstre avec des valeurs par defaut
     */
    
    public Monstre(){
        
    this.pos= new Point2D();
    
    }
    
    // Accesseurs et modificateurs
    /** 
     * @return le nombre de points de Vie
     */
    public int getPtVie(){
        return ptVie;
    }
    
    /**
     * 
     * @return le degré d'attaque
     */
    public int getDegAtt() {
        return degAtt;
    }
    
    /**
     * 
     * @return les points de parade
     */
    public int getPtPar() {
        return ptPar;
    }
    
    /**
     * 
     * @return  le pourcentage d'attaque
     */
    public int getPageAtt() {
        return pageAtt;
    }
    
    /**
     * 
     * @return  le pourcentage de parade
     */
    public int getPagePar() {
        return pagePar;
    }
    
    /**
     * 
     * @return la position du personnage
     */
    public Point2D getPos() {
        return pos;
    }
    
     /**
     * modifie les points de vie
     * @param ptVie
     */
    public void setPtVie(int ptVie){
        this.ptVie=ptVie;
    
    }
    
    /**
     * modifie le degré d'attaque
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    
    /**
     * modifie les points de parade
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }
    
    /**
     * modifie le pourcentage d'attaque
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }
    
    /**
     * modifie le pourcentage de parade
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }
    
    /**
     * modifie la position
     * @param pos
     */

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    // methode deplace
    /**
     * methode deplace permet de deplacer aléatoirement un objet sur une case adjacente
     * de la ou il se trouve
     */
    
    public void deplace() {
        Random rand = new Random();
        // Déplacement aléatoire entre -1 et 1 sur les axes x et y
        int deltaX = rand.nextInt(3) - 1; // Valeur aléatoire entre -1 et 1
        int deltaY = rand.nextInt(3) - 1;

        // Mettre à jour la position
        pos.setX(pos.getX() + deltaX);
        pos.setY(pos.getY() + deltaY);
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
