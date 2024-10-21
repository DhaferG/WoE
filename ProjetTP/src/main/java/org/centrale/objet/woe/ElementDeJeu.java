package org.centrale.objet.woe;

/**
 * la classe ElementDeJeu permet de gérer les positions d'un élement de jeu
 * @author nourkouki
 * @author dghanmi
 */
public abstract class ElementDeJeu {
    public Point2D pos;
    public String nom;
    /*Constructeur de la classe élement de jeu
     * Attributs:
     * pos: Point2D
     */
    
    public ElementDeJeu(Point2D pos){
        this.pos= pos;
    }
    
    public ElementDeJeu(ElementDeJeu e){
        this.pos=new Point2D(e.pos);
        this.nom=e.nom;
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
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom=nom;
    }
}
