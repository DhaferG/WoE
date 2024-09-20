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
public class Monstre {
    public int ptVie;
    public int degAtt;
    public int ptPar;
    public int pageAtt;
    public int pagePar;
    public Point2D pos;
    
    // constructeurs
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        ptVie= pV;
        degAtt = dA;
        ptPar = pPar;
        pageAtt = paAtt;
        pagePar = paPar;
        pos = p;
    }
    
    public Monstre(Monstre m) {
        this.ptVie=m.ptVie;
        this.degAtt=m.degAtt;
        this.ptPar=m.ptPar;
        this.pageAtt=m.pageAtt;
        this.pagePar=m.pagePar;
        this.pos=m.pos;
        
    }
    
    public Monstre(){
        
    this.pos= new Point2D();
    
    }
    
    // getters and setters
    
    public int getPtVie(){
        return ptVie;
    }
    
    public void setPtVie(int pv){
        this.ptVie=pv;
    
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

    public Point2D getPos() {
        return pos;
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

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    // methode deplace
    
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
