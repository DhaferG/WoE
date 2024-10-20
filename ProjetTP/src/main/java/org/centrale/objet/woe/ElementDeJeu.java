package org.centrale.objet.woe;

/**
 * la classe ElementDeJeu permet de gérer les positions d'un élement de jeu
 * @author nourkouki
 * @author dghanmi
 */
public abstract class ElementDeJeu {
    Point2D pos;
    /*Constructeur de la classe élement de jeu
     * Attributs:
     * pos: Point2D
     */
    
    public ElementDeJeu(Point2D pos){
        this.pos= pos;
    }
    
    public ElementDeJeu(ElementDeJeu e){
        this.pos=new Point2D(e.pos);
    }
    
    public ElementDeJeu(){
        this.pos=new Point2D();
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
}
