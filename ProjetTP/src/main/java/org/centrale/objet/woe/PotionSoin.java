package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * sous classe d'objet gérant les potions de soins
 * @author nourkouki
 * @author dghanmi
 */

public class PotionSoin extends Objet{
    
    /**
     * Attribut de la class
     * health: pts de Vie que la potion donne
     */
    public int health;
    public PotionSoin(Point2D pos,int health) {
    /** Constructeur de la classe PotionSoin sous-classe d'objet avec les paramètres
     * @param pos: position de la potion
     * @param pts: points à gagner en trouvant la potion
     */
        super(pos, 10,"Potion");
        this.health = health;
    }
    
    /** 
     * Méthode permettant d'utiliser la potion
     * @param c: personnage qui consomme la potion
     */
    public void consume(Joueur j){
        if (j.getPersonnage().getPtVie()==j.getMaxHealth()){
            System.out.println("Potion Wasted");
        }
        else{
            j.getPersonnage().setPtVie(Math.min(j.getPersonnage().getPtVie()+this.health,j.getMaxHealth()));
        }
    }
    
    /**
     *
     * @param connection
     * @param ID_sauvegarde
     * @param id_inventaire
     * @param i
     */

    public void saveToDatabase(Connection connection,int ID_sauvegarde, int id_inventaire, int i) {
        try{
            String Query = "insert into objet(nom_objet,XP,x,y)values('potionSoin" + i + "'," + this.XP+',' + this.pos.x+',' + this.pos.y + ") ";
            PreparedStatement stm = connection.prepareStatement(Query);
            stm.executeUpdate();
            String Query2="insert into contient_potionSoin(nom_potionSoin,id_inventaire)values('postioSoin" + i + "'," +id_inventaire+") " ;
            PreparedStatement stm2=connection.prepareStatement(Query2);
            stm2.executeUpdate();
            System.out.println("PotionSoin nom: potionSoin"+i+" a la position:["+this.pos.x+","+this.pos.y+']');
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
     * @param nom_potionSoin
     */

    public void getFromDatabase(Connection connection, Integer id,int id_inventaire, String nom_potionSoin) {
        try{
        String Query = "select nom_potionSoin,XP,x,y from objet inner join contient_potionSoin using(nom_potionSoin) inner join inventaire using(id_inventaire) inner join contient_inventaire using(id_inventaire) where id_sauvegarde= " + id+"and id_inventaire="+id_inventaire+" and nom_potionSoin='"+nom_potionSoin+"'";
        PreparedStatement stm = connection.prepareStatement(Query);
        ResultSet rs = stm.executeQuery();
        rs.next();
        
        this.pos.x=rs.getInt("x");
        this.pos.y=rs.getInt("y");
        this.XP=rs.getInt("XP");
        System.out.println("nom potionSoin est: "+ nom_potionSoin + " x: "+this.pos.x+" y: "+this.pos.y+" pts XP: "+this.XP);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
