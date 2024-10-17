package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sous classe d'objet gérant les épées
 * @author nourkouki
 * @author dghanmi
 */
public class Epee extends Objet implements Utilisable{
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
    public void use(Joueur j){
        Personnage p = j.getPersonnage();
        p.degAtt+=this.degAtt;
    }
    public void AddToInventory(Joueur j){
        // TODO: Methode Joueur ManageInventory to add objects
    }
    public void SeeEffect(){}
    
    /**
     *
     * @param connection
     * @param ID_sauvegarde
     * @param id_inventaire
     * @param i
     */
    @Override
    public void saveToDatabase(Connection connection,int ID_sauvegarde, int id_inventaire, int i) {
        try{
            String Query = "insert into Objet(nom_objet,XP,x,y)values('epee" + i + "'," + this.XP+',' + this.pos.x+',' + this.pos.y + ") ";
            PreparedStatement stm = connection.prepareStatement(Query);
            stm.executeUpdate();
            String Query2="insert into contient_epee(nom_epee,id_inventaire)values('epee" + i + "'," +id_inventaire+") " ;
            PreparedStatement stm2=connection.prepareStatement(Query2);
            stm2.executeUpdate();
            System.out.println("Epee nom: epee"+i+" a la position:["+this.pos.x+","+this.pos.y+']');
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
     * @param nom_epee
     */
    @Override
    public void getFromDatabase(Connection connection, Integer id,int id_inventaire, String nom_epee) {
        try{
        String Query = "select nom_epee,XP,x,y from objet inner join contient_epee using(nom_epee) inner join inventaire using(id_inventaire) inner join contient_inventaire using(id_inventaire) where id_sauvegarde= " + id+"and id_inventaire="+id_inventaire+" and nom_epee='"+nom_epee+"'";
        PreparedStatement stm = connection.prepareStatement(Query);
        ResultSet rs = stm.executeQuery();
        rs.next();
        
        this.pos.x=rs.getInt("x");
        this.pos.y=rs.getInt("y");
        this.XP=rs.getInt("XP");
        System.out.println("nom epee est: "+ nom_epee + " x: "+this.pos.x+" y: "+this.pos.y+" pts XP: "+this.XP);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
