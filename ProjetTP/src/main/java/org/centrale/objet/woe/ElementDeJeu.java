package org.centrale.objet.woe;

/**
 * la classe ElementDeJeu permet de gérer les positions d'un élement de jeu
 * @author nourkouki
 * @author dghanmi
 */
public abstract class ElementDeJeu {
    // attributs
    /**
     * position
    */
    public Point2D pos;
    /**
     * nom
     */
    public String nom;
    /**
     * constructeur
     * @param pos : position
     */
    public ElementDeJeu(Point2D pos){
        this.pos= pos;
    }
    
    /**
     * constructeur de recopie
     * @param e: element de jeu
     */
    
    public ElementDeJeu(ElementDeJeu e){
        this.pos=new Point2D(e.pos);
        this.nom=e.nom;
    }
    /**
     * constructeur par defaut
     */
    
    public ElementDeJeu(){
        this.pos=new Point2D();
    }
    /**
     * get position
     * @return pos
     */
    public Point2D getPos() {
        return pos;
    }
    /**
     * set position
     * @param pos : position
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    /**
     * get nom
     * @return nom
     */
    public String getNom() {
        return this.nom;
    }
    /**
     * set nom
     * @param nom : nom
     */
    public void setNom(String nom) {
        this.nom=nom;
    }
}
