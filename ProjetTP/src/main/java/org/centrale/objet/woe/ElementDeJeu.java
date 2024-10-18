package org.centrale.objet.woe;

public abstract class ElementDeJeu {
    public Point2D pos;
    public String nom;
    /*Constructeur de la classe élement de jeu
     * Attributs:
     * pos: Point2D
     */
    public ElementDeJeu(){
        this.pos=new Point2D();
    }

    public ElementDeJeu(Point2D p){
        this.pos= new Point2D(p);
    }

    public ElementDeJeu(ElementDeJeu e){
        this.pos=new Point2D(e.pos);
        this.nom=e.nom;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom=nom;
    }
}
