package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Permet de gérer les nuage toxiques
 * @author nourkouki
 * @author dghanmi
 */

public class NuageToxique extends Objet implements Deplacable {
    int dureeEffet;
    int Debuff;
    public NuageToxique(Point2D pos, int malus, int dureeEffet){
        super(pos, 100,"");
        this.dureeEffet=dureeEffet;
        this.Debuff=malus;
    }
    public void deplace(World w, int dx, int dy){        
        int x = this.pos.getX();
        int y = this.pos.getY();
        int h = w.getTailleMonde();
        if ((x+dx<h) &&(x+dx>=0)&& (y+dy>=0)&&(y+dy<h)){
            {
                this.setPos(new Point2D(x+dx,y+dy));
            }
        }
        else{
            this.setPos(new Point2D(x,y));
        }
    }
    public int BuffDuration(){
        return this.dureeEffet;
    }
    public void Debuff(Joueur j){
        if (j.getPersonnage().pos==this.pos){
            j.getPersonnage().setDegAtt(j.getPersonnage().getDegAtt()-this.Debuff);
        }
    }

    /**
     *
     * @param connection
     * @param ID_sauvegarde
     * @param i
     */


    public void saveToDatabase(Connection connection, int ID_sauvegarde, int i) {
    try {
        // Requête pour insérer un objet dans la table "Objet"
        String query = "INSERT INTO Objet(nom_objet, XP, x, y) VALUES (?, ?, ?, ?)";
        PreparedStatement stm = connection.prepareStatement(query);
        
        // Définir les paramètres pour la requête
        stm.setString(1, "NuageToxique" + i);          // nom_objet (ex: 'NuageToxique1')
        stm.setInt(2, this.XP);                // XP (expérience de l'objet)
        stm.setInt(3, this.pos.getX());        // x (coordonnée X)
        stm.setInt(4, this.pos.getY());        // y (coordonnée Y)

        // Exécuter la requête
        stm.executeUpdate();

        // Confirmation dans la console
        System.out.println("Nuage Toxique nom: NuageToxique" + i + " à la position: [" + this.pos.getX() + "," + this.pos.getY() + "]");
        } catch (SQLException ex) {
        Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    /**
     *
     * @param connection
     * @param id
     * @param nom_objet
     */

    public void getFromDatabase(Connection connection, Integer id, String nom_objet) {
    try {
        // Requête avec des paramètres pour éviter la concaténation
        String query = "SELECT o.nom_objet, o.XP, o.x, o.y "
                     + "FROM objet o "
                     + "INNER JOIN est_dans_une_sauv s on s.nom_objet=o.nom_objet "
                     + "INNER JOIN partie p on s.id_partie=p.id_partie "
                     + "WHERE p.id_sauvegarde = ? AND o.nom_objet = ?";
        
        PreparedStatement stm = connection.prepareStatement(query);
        
        // Définir les paramètres pour la requête
        stm.setString(1, id.toString());                // Paramètre 1 : id_sauvegarde
        stm.setString(2, nom_objet);       // Paramètre 3 : nom_objet
        
        // Exécuter la requête
        ResultSet rs = stm.executeQuery();

        // Si un résultat est trouvé, récupérer les valeurs
        if (rs.next()) {
            if (this.pos == null) {
                this.pos = new Point2D();  // Initialiser pos si elle est null
            }
            this.pos.setX(rs.getInt("x"));  // Récupérer x
            this.pos.setY(rs.getInt("y"));  // Récupérer y
            this.XP = rs.getInt("XP");      // Récupérer les points d'expérience (XP)
            
            System.out.println("Nom du nuage toxique : " + nom_objet + " Position: [" + this.pos.getX() + ", " + this.pos.getY() + "] XP: " + this.XP);
        } else {
            System.out.println("Aucun nuage toxique trouvée avec le nom: " + nom_objet);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
