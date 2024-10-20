package org.centrale.objet.woe;

public class Nourriture extends Objet implements Utilisable {
    int dureeEffet;
    int DefBoost;
    public Nourriture(Point2D pos, int DefBoost, int dureeEffet){
        super(pos, 10,"");
        this.dureeEffet=dureeEffet;
        this.DefBoost=DefBoost;
    }
    public void use(Joueur j){
        Personnage p = j.getPersonnage();
        p.setPtPar(p.getPagePar()+this.DefBoost);
    }
    public int BuffDuration(){
        return this.dureeEffet;
    }
    public void SetBuffDuration(int b){
        this.dureeEffet=b;
    }
    public void DebuffAfterEnd(Joueur j){
        Personnage p = j.getPersonnage();
        p.setPtPar(p.getPagePar()-this.DefBoost);
    }
    public int getBuffDetails(){
        return this.DefBoost;
    }
}
