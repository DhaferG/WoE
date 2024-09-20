/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

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
    
    public void deplace(){
        
    }
    
    // methode affiche
    
    public void affiche(){
        
    }    
}
