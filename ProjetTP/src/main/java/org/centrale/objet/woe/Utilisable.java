package org.centrale.objet.woe;

/**
 * Interface utilisable
 * @author nourkouki
 * @author dghanmi
 */

public interface Utilisable {
    public void use(Joueur j);
    public int BuffDuration();
    public void SetBuffDuration(int i);
    public void DebuffAfterEnd(Joueur j);
    public int getBuffDetails();

}
