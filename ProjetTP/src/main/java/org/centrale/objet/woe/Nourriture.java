package org.centrale.objet.woe;

import java.sql.Connection;

public class Nourriture extends Objet {
    public Nourriture(Point2D pos,int pts){
        super(pos, pts);
    }

    @Override
    public void saveToDatabase(Connection connection, int ID_sauvegarde, int id_inventaire, int i) {
        
    }

    @Override
    public void getFromDatabase(Connection connection, Integer id, int id_inventaire, String nom_objet) {
    }
    

}
