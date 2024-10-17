package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * sous classe de personnage gérant les guerriers
 * @author nourkouki
 * @author dghanmi
 */

public class Guerrier extends Personnage implements Combattant {
    // Constructeurs
    /**
     * Un constructeur de la classe Guerrier avec 8 parametres
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
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p, n, dMax);
    }
     /**
     * Un constructeur de recopie de la classe Guerrier
     * permet de creer un personnage à partir d'un autre guerrier existant
     * @param g: un personnage guerrier
     */
    public Guerrier(Guerrier g) {
        super(g);
        this.pos= new Point2D(g.pos);
    }

    public Guerrier() {
        super();
    }

    
    /** 
     * Methode combattre permettant Guerrier de combattre des créatures c
     * @param c: créature à combattre
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
                    c.ptVie -= this.degAtt;
                } else {
                    c.ptVie = c.ptVie -this.degAtt + c.ptPar;
                }
            }
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
            String Query = "insert into humanoide(nom_hum, id_hum, id_creature, type_hum) values('" + this.nom + "', h- '" + i + "', c- '" + i + "', 'Guerrier')";
            PreparedStatement stm = connection.prepareStatement(Query);
            stm.executeUpdate();
            String Query1 = "insert into creature(id_creature, pos_x, pos_y) values('c-" + i + "', " + this.pos.x + ", " + this.pos.y + ")";
            PreparedStatement stm1 = connection.prepareStatement(Query1);
            stm1.executeUpdate();
            System.out.println("Guerrier nom:" + this.nom + i);
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
            String Query = "select h.nom_hum, h.id_hum, c.pos_x, c.pos_y from humanoide h inner join creature c using(id_creature) inner join est_dans_une_sauv s using(id_creature) where s.id_sauvegarde= " + id + "and h.type_hum='Guerrier'and h.nom_hum='" + nom_humanoide + "'";
            PreparedStatement stm = connection.prepareStatement(Query);
            ResultSet rs = stm.executeQuery();
            rs.next();
            while (rs.next()) {
                this.nom = rs.getString("h.nom_hum");
                this.pos.x = rs.getInt("c.pos_x");
                this.pos.y = rs.getInt("c.pos_y");
                System.out.println("Guerrier: nom: " + this.nom + " x: " + this.pos.x + " y: " + this.pos.y);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
}
