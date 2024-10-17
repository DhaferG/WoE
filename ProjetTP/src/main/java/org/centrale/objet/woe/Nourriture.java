package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Nourriture extends Objet {
    public Nourriture(Point2D pos,int pts){
        super(pos, pts);
    }
    
    /**
     *
     * @param connection
     * @param ID_sauvegarde
     * @param id_inventaire
     * @param i
     */

    @Override
    public void saveToDatabase(Connection connection, int ID_sauvegarde, int id_inventaire, int i) {
        try{
           String Query="insert into objet(nom_objet,XP,x,y)values('miel" + i + "'," + this.XP+',' +this.pos.x+','+this.pos.y+") " ;
           PreparedStatement stm=connection.prepareStatement(Query);
           stm.executeUpdate();
           String Query2="insert into contient_nourriture(nom_nourriture,id_inventaire)values('miel" + i + "'," +id_inventaire+") " ;
           PreparedStatement stm2=connection.prepareStatement(Query2);
           stm2.executeUpdate();
           System.out.println("Nourriture nom: miel" + i + "'," +" a la position:["+this.pos.x+","+this.pos.y+"]");
           
        }
      catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    /**
     *
     * @param connection
     * @param id
     * @param id_inventaire
     * @param nom_nourriture
     */
    @Override
    public void getFromDatabase(Connection connection, Integer id,int id_inventaire,String nom_nourriture) {
        try{
        String Query = "select nom_objet,XP,x,y from objet o inner join contient_nourriture c on o.nom_objet=c.nom_nourriture inner join inventaire using(id_inventaire) inner join contient_inventaire using(id_inventaire) where id_sauvegarde= " + id+"and id_inventaire="+id_inventaire+" and nom_nourriture='"+nom_nourriture+"'";
        PreparedStatement stm = connection.prepareStatement(Query);
        ResultSet rs = stm.executeQuery();
        rs.next();
        this.pos.x=rs.getInt("x");
        this.pos.y=rs.getInt("y");
        this.XP=rs.getInt("XP");
        System.out.println("nom nourriture est: "+ nom_nourriture +" x: "+this.pos.x+" y: "+this.pos.y);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    

}
