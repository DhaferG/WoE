package org.centrale.objet.woe;

public abstract class ElementDeJeu {
    Point2D pos;
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
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
}
