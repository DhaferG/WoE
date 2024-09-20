/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Random;

/**
 *
 * @author nourkouki
 */

public class Personnage {
    /**
     * le nom du personnage
     */
    public String nom;
    
    /**
     * Points de Vie du personnage
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
     * distance d'attaque maximale
     */
    public int distAttMax;
    
    
    /**
     * position du personnage
     */
    public Point2D pos;

    // Constructeurs
    /**
     * permet d'attribuer des caractéristiques à un personnage et prend 8 parametres
     * @param n: nom du personnage
     * @param pVie: les points de vie du personnage
     * @param dAtt: degré d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param dMax: distance maximale d'attaque
     * @param p: position du personnage 
     * 
    */
    
    public Personnage(String n, int pVie, int dAtt, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        this.nom = n;
        this.ptVie = pVie;
        this.degAtt = dAtt;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.distAttMax = dMax;
        this.pos = p;
    }

    /**
     * permet de creer un personnage à partir d'un autre personnage existant
     * @param perso: un personnage exitant
     */
    
    public Personnage(Personnage perso) {
        this.nom = perso.nom;
        this.ptVie = perso.ptVie;
        this.degAtt = perso.degAtt;
        this.ptPar = perso.ptPar;
        this.pageAtt = perso.pageAtt;
        this.pagePar = perso.pagePar;
        this.distAttMax = perso.distAttMax;
        this.pos = perso.pos;
    }
    
    /**
     * permet de creer un personnage avec des valeurs par defaut
     */
    
    public Personnage() {
        this.nom = "";
        this.ptVie = 0;
        this.degAtt = 0;
        this.ptPar = 0;
        this.pageAtt = 0;
        this.pagePar = 0;
        this.distAttMax = 0;
        this.pos = new Point2D();
    }

    // Accesseurs et modificateurs
    public String getNom() {
        return nom;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    public int getPtVie() {
        return ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * methode deplace permet dde deplacer aléatoirement un objet sur une case adjacente
     * de la ou il se trouve
     */

    // Méthode de déplacement aléatoire
    public void deplace() {
        Random rand = new Random();
        // Déplacement aléatoire entre -1 et 1 sur les axes x et y
        int deltaX = rand.nextInt(3) - 1; // Valeur aléatoire entre -1 et 1
        int deltaY = rand.nextInt(3) - 1;

        // Mettre à jour la position
        pos.setX(pos.getX() + deltaX);
        pos.setY(pos.getY() + deltaY);
    }

    /**
     * methode affiche permet d'afficher les caractéristique d'un personnage
     */
    //methode affiche
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



