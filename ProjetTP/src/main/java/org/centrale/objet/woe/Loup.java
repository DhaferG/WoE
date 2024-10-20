package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * sous classe de Monstre gérant les Loups
 * @author nourkouki
 * @author dghanmi
 */
public class Loup extends Monstre implements Combattant {
    // constructeurs
    /**
     * Un constructeur de la classe Monstre avec 6 parametres
     * @param pV: points de vie
     * @param dA: degats d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param p: position du monstre 
     * 
    */
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    }
     /**
     * Constructeur de recopie de la classe Loup
     * permet de creer un monstre à partir d'un autre loup existant
     * prend un seul parametre
     * @param l: un loup exitant
     */
    public Loup(Loup l) {
        super(l);
    }

    public Loup() {
        super();
    }

    
    /** 
     * @param c: Creature à combattre
     */
    public void combattre(Creature c){
    }
    
    /**
     *
     * @param connection
     * @param ID_sauvegarde
     * @param i
     */
    @Override
    public void saveToDatabase(Connection connection, int ID_sauvegarde, int i) {
        try {
            String Query = "insert into monstre(id_mon, id_creature, type_monstre) values('loup" + i + "'," + "', c- '" + i + "', 'Loup')";
            PreparedStatement stm = connection.prepareStatement(Query);
            stm.executeUpdate();
            String Query1 = "insert into creature(id_creature, pos_x, pos_y) values('c-" + i + "', " + this.pos.x + ", " + this.pos.y + ")";
            PreparedStatement stm1 = connection.prepareStatement(Query1);
            stm1.executeUpdate();
            System.out.println("Loup nom:loup" + i);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    /**
     *
     * @param connection
     * @param id
     * @param nom_monstre
     */
    @Override
    public void getFromDatabase(Connection connection, Integer id, String nom_monstre) {
        try {
            String Query = "select m.id_mon, c.pos_x, c.pos_y from monstre m inner join creature c using(id_creature) inner join est_dans_une_sauv s using(id_creature) where s.id_sauvegarde= " + id + "and m.type_mon='Loup'and m.id_mon='" + nom_monstre + "'";
            PreparedStatement stm = connection.prepareStatement(Query);
            ResultSet rs = stm.executeQuery();
            rs.next();
            while (rs.next()) {
                this.pos.x = rs.getInt("c.pos_x");
                this.pos.y = rs.getInt("c.pos_y");
                System.out.println("nom_monstre: " + nom_monstre + " x: " + this.pos.x + " y: " + this.pos.y);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
