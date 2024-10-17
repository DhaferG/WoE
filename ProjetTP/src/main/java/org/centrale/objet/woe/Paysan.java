/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Paysan sous classe de Personnage définit les caractéristiques d'un Paysan
 * @author nourkouki
 * @author dghanmi
 */
public class Paysan extends Personnage {

    // Constructeurs
    /**
     * 
     * @param n: nom du personnage
     * @param pV: les points de vie du personnage
     * @param dA: degats d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param dMax: distance maximale d'attaque
     * @param p: position du personnage 
     *
     */
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p, n, dMax);
    }
    /**
     * Constructeur de recopie
     * @param p : un paysan déja existant
     */

    public Paysan(Paysan p) {
        super(p);
        this.pos= new Point2D(p.pos);
    }
    
    /**
     * Constructeur par defaut
     */
    public Paysan() {
        super();
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
            String Query = "insert into humanoide(nom_hum, id_hum, id_creature, type_hum) values('" + this.nom + "', h- '" + i + "', c- '" + i + "', 'Paysan')";
            PreparedStatement stm = connection.prepareStatement(Query);
            stm.executeUpdate();
            String Query1 = "insert into creature(id_creature, pos_x, pos_y) values('c-" + i + "', " + this.pos.x + ", " + this.pos.y + ")";
            PreparedStatement stm1 = connection.prepareStatement(Query1);
            stm1.executeUpdate();
            System.out.println("Paysan nom:" + this.nom + i);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    /**
     *
     * @param connection
     * @param id
     * @param nom_humanoide
     */
    @Override
    public void getFromDatabase(Connection connection, Integer id, String nom_humanoide) {
        try {
            String Query = "select h.nom_hum, h.id_hum, c.pos_x, c.pos_y from humanoide h inner join creature c using(id_creature) inner join est_dans_une_sauv s using(id_creature) where s.id_sauvegarde= " + id + "and h.type_hum='Paysan'and h.nom_hum='" + nom_humanoide + "'";
            PreparedStatement stm = connection.prepareStatement(Query);
            ResultSet rs = stm.executeQuery();
            rs.next();
            while (rs.next()) {
                this.nom = rs.getString("h.nom_hum");
                this.pos.x = rs.getInt("c.pos_x");
                this.pos.y = rs.getInt("c.pos_y");
                System.out.println("Paysan: nom: " + this.nom + " x: " + this.pos.x + " y: " + this.pos.y);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
