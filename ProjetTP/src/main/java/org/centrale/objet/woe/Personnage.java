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
    
    public String nom;
    public int ptVie;
    public int degAtt;
    public int ptPar;
    public int pageAtt;
    public int pagePar;
    public int distAttMax;
    public Point2D pos;

    // Constructeurs
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
    

    // methode deplace
    public void deplace() {
        Random rand = new Random();
        // Définir une valeur maximale de déplacement pour chaque direction
        int maxDeplacement = 5; // Vous pouvez ajuster cette valeur
        int deltaX = rand.nextInt(maxDeplacement * 2 + 1) - maxDeplacement; // Valeur aléatoire entre -maxDeplacement et maxDeplacement
        int deltaY = rand.nextInt(maxDeplacement * 2 + 1) - maxDeplacement;

        // Déplacer le personnage
        pos.setX(pos.getX() + deltaX);
        pos.setY(pos.getY() + deltaY);
}

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



