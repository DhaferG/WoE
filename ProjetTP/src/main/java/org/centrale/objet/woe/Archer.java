/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * la classe Archer sous classe de Personnage définit le personnage Archer
 * @author nourkouki
 * @author dghanmi
 */


public class Archer extends Personnage implements Combattant {
    //Attributs
    /**
     * le nombre de fleches de l'Archer
     */
    public int nbFleches;

    // Constructeurs
    /**
     * 
     * @param n: du personnage
     * @param pV: les points de vie du personnage
     * @param dA: degats d'attaque
     * @param pPar: points de parade
     * @param paAtt: Pourcentage d'attaque
     * @param paPar: pourcentage de parade
     * @param dMax: distance maximale d'attaque
     * @param p: position du personnage 
     * @param nbFleches : nombre de fleches
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches) {
        super(pV, dA, pPar, paAtt, paPar, p, n, dMax);
        this.nbFleches = nbFleches;
    }

    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;
    }

    public Archer() {
        super();
    }
    
    
    /** 
     * Methode combattre définit le systeme de combat 
     * @param c : une creature
     */
    public void combattre(Creature c){
        double d = this.pos.distance(c.pos);
        boolean attaque = true;
        Random x = new Random();
        if (d == 1) {
            int y = x.nextInt(100);
            System.out.println("Rand du tirage aléatoire" + y);
            if (y > this.pageAtt) {
                attaque = false;
            }
            System.out.println("attaque " + attaque);
            if (attaque) {
                int z = x.nextInt(100);
                if (z > c.pagePar) {
                    c.ptVie = this.degAtt;
                } else {
                    c.ptVie -= (this.ptVie - c.ptPar);
                }
            }
        }
        if ((d < this.distAttMax) && (d > 1)) {
            int y = x.nextInt(100);
            if (y > this.pageAtt) {
                attaque = false;
            }
            if (attaque) {
                this.nbFleches-=1;
                c.ptVie -= this.degAtt;

            }
        }
        if (d >= this.distAttMax) {
            System.out.println("Echec");
        }

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
            String Query = "insert into humanoide(nom_hum, id_hum, id_creature, type_hum) values('" + this.nom + "', h- '" + i + "', c- '" + i + "', 'Archer')";
            PreparedStatement stm = connection.prepareStatement(Query);
            stm.executeUpdate();
            String Query1 = "insert into creature(id_creature, pos_x, pos_y) values('c-" + i + "', " + this.pos.x + ", " + this.pos.y + ")";
            PreparedStatement stm1 = connection.prepareStatement(Query1);
            stm1.executeUpdate();
            System.out.println("Archer nom:" + this.nom + i);
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
            String Query = "select h.nom_hum, h.id_hum, c.pos_x, c.pos_y from humanoide h inner join creature c using(id_creature) inner join est_dans_une_sauv s using(id_creature) where s.id_sauvegarde= " + id + "and h.type_hum='Archer'and h.nom_hum='" + nom_humanoide + "'";
            PreparedStatement stm = connection.prepareStatement(Query);
            ResultSet rs = stm.executeQuery();
            rs.next();
            while (rs.next()) {
                this.nom = rs.getString("h.nom_hum");
                this.pos.x = rs.getInt("c.pos_x");
                this.pos.y = rs.getInt("c.pos_y");
                System.out.println("Archer: nom: " + this.nom + " x: " + this.pos.x + " y: " + this.pos.y);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}

