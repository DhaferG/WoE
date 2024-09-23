/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Random;

/**
 * la classe Personnage permet d'attribuer des caractéristiques à un personnage
 * @author nourkouki
 * @author dghanmi
 */

public class Personnage extends Creature {
    
    //Attributs de la classe
    
    /**
     * le nom du personnage
     */
    public String nom;
    /**
     * distance d'attaque maximale
     */
    public int distAttMax;
    
    // Constructeurs
    /**
     * Un constructeur de la classe Personnage avec 8 parametres
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
    
    public Personnage(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, String n, int dMax) {
        super(pV, dA, pPar, paAtt, paPar, p);
        this.nom = n;
        this.distAttMax = dMax;
    }

    /**
     * Un constructeur de recopie de la classe Personnage
     * permet de creer un personnage à partir d'un autre personnage existant
     * @param perso: un personnage exitant
     */
    
    public Personnage(Personnage perso) {
        super(perso);
        this.nom=perso.nom;
        this.distAttMax=perso.distAttMax;
    }
    
    /**
     * Un constructeur par défaut de la classe Personnage
     * permet de creer un personnage avec des valeurs par defaut
     */
    
    public Personnage() {
        super();
    }

    // Accesseurs et modificateurs
    
    /**
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }
    
    /** 
     * @return le nombre de points de Vie
     */

    public int getPtVie() {
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
     * @return la distance maximale d'attaque
     */

    public int getDistAttMax() {
        return distAttMax;
    }
    /**
     * 
     * @return la position du personnage
     */

    public Point2D getPos() {
        return pos;
    }
    
    /**
     * modifie le nom du personnage
     * @param n : le nom du personnage
     */

    public void setNom(String n) {
        this.nom = n;
    }
    
    /**
     * modifie les points de vie
     * @param ptVie
     */

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
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
     * modifie la distance d'attaque maximale
     * @param distAttMax
     */

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    
    /**
     * modifie la position
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    // Méthode de déplacement aléatoire
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

    // Methode affiche
    /**
     * methode affiche permet d'afficher les caractéristique d'un personnage
     */
    
    public void affiche() {
    System.out.println("Nom : " + nom);
    System.out.println("Points de vie : " + ptVie);
    System.out.println("Dégâts d'attaque : " + degAtt);
    System.out.println("Points de parade : " + ptPar);
    System.out.println("Pourcentage d'attaque : " + pageAtt);
    System.out.println("Pourcentage de parade : " + pagePar);
    System.out.println("Distance d'attaque maximale : " + distAttMax);
    System.out.print("Position : ");
    pos.afficher();
    }
    
    
}



