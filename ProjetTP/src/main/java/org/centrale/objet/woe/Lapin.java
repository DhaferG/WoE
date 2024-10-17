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
 * Classe Lapin sous classe de Monstre définit les caractéristiques d'un Monstre Lapin
 * @author nourkouki
 * @author dghanmi
 */

public class Lapin extends Monstre {
    
    // constructeurs
    /**
     * Un constructeur de la classe Lapin sous-classe de Monstre avec 6 parametres
     * @param pV: points de vie
     * @param dA: degats d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param p: position du monstre 
     * 
    */
    public Lapin(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
    
    }
    /**
     * Constructeur de recopie de la classe Lapin
     * permet de creer un monstre à partir d'un autre lapin existant
     * prend un seul parametre
     * @param l: un lapin exitant
     */
    public Lapin(Lapin l){
        super(l);
        this.pos= new Point2D(l.pos);
    }
    /**
     * Constructeur par défaut
     */
    
    public Lapin(){
    
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
            String Query = "insert into monstre(id_mon, id_creature, type_monstre) values('lapin" + i + "'," + "', c- '" + i + "', 'Lapin')";
            PreparedStatement stm = connection.prepareStatement(Query);
            stm.executeUpdate();
            String Query1 = "insert into creature(id_creature, pos_x, pos_y) values('c-" + i + "', " + this.pos.x + ", " + this.pos.y + ")";
            PreparedStatement stm1 = connection.prepareStatement(Query1);
            stm1.executeUpdate();
            System.out.println("Lapin nom:lapin" + i);
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
            String Query = "select m.id_mon, c.pos_x, c.pos_y from monstre m inner join creature c using(id_creature) inner join est_dans_une_sauv s using(id_creature) where s.id_sauvegarde= " + id + "and m.type_mon='Lapin'and m.id_mon='" + nom_monstre + "'";
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
