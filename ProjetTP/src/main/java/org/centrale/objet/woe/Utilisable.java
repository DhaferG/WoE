package org.centrale.objet.woe;

/**
 * Interface utilisable
 * @author nourkouki
 * @author dghanmi
 */

public interface Utilisable {
    public void use(Joueur j);
    public void AddToInventory(Joueur j);
    public void SeeEffect();

}
