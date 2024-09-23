package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 * @author dghanmi
 */
public class Epee extends Objet{
    /**
     * Attribut de la class
     * degAtt: pts de Vie que la potion donne
     */
    public int degAtt;
    /*
     * Constructeur à partir de deux paramètres et la classe Objet
     * pos: position de l'objet
     * pts: Points expérience gagnés grâce à l'objet - Peut être ignoré pour le moment
     */
    public Epee(Point2D pos,int pts,int degAtt) {
        super(pos, pts);
        this.degAtt = degAtt;
    }
}
