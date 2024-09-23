package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 * @author dghanmi
 */
public class Objet {
    /*
     * Attributs de la classe
     * pos: position de l'objet
     * XP: Points expérience gagnés grâce à l'objet - Peut être ignoré pour le moment
     */
    public Point2D pos;
    public int XP;
    public Objet (Point2D pos,int pts) {
        this.pos=pos;
        this.XP=pts;
    }
}
