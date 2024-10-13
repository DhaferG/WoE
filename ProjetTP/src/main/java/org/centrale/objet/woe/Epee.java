package org.centrale.objet.woe;

/**
 * Sous classe d'objet gérant les épées
 * @author nourkouki
 * @author dghanmi
 */
public class Epee extends Objet{
    /**
     * Attribut de la class
     * degAtt: pts de Vie que la potion donne
     */
    private int degAtt;
   /**
    * Constructeur à partir de deux paramètres et la classe Objet
    * @param pos: position de l'objet
    * @param pts: Points expérience gagnés grâce à l'objet - Peut être ignoré pour le moment
    * @param degAtt: degats d'attaque
    */
    public Epee(Point2D pos,int pts,int degAtt) {
        super(pos, pts);
        this.degAtt = degAtt;
    }
}
