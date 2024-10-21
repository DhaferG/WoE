package org.centrale.objet.woe;

/**
 * Interface CDeplacable
 * @author nourkouki
 * @author dghanmi
 */
public interface Deplacable {
    /**
     * méthode deplace
     * @param w : monde
     * @param dx: deplacement sur x
     * @param dy: deplacement sur y
     */
    public void deplace(World w, int dx , int dy);
}
