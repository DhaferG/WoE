package org.centrale.objet.woe;

import java.sql.Connection;

/**
 * Classe Objet gérant les objets
 * @author nourkouki
 * @author dghanmi
 */
public abstract class Objet extends ElementDeJeu{
    // Attributs de la classe
     /** 
      * position de l'objet
      */
    /**
     * Points expérience gagnés grâce à l'objet
     */
    public int XP;
    // constructeur
    /**
     * Constructeur de la classe Objet
     * @param pos: position de l'objet
     * @param pts: Points expérience gagnés grâce à l'objet 
     */
    public Objet (Point2D pos,int pts) {
        super(pos);
        this.XP=pts;
    }
    
    public abstract void saveToDatabase(Connection connection,int ID_sauvegarde,int id_inventaire,int i);
    public abstract void getFromDatabase(Connection connection, Integer id,int id_inventaire,String nom_objet);
    
}
