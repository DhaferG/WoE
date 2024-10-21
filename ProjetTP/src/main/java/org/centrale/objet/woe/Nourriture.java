package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Permet de gérer les nourritures
 * @author nourkouki
 * @author dghanmi
 */

public class Nourriture extends Objet implements Utilisable {
    int dureeEffet;
    int DefBoost;
    public Nourriture(Point2D pos, int DefBoost, int dureeEffet){
        super(pos, 10,"");
        this.dureeEffet=dureeEffet;
        this.DefBoost=DefBoost;
    }
    public void use(Joueur j){
        Personnage p = j.getPersonnage();
        p.setPtPar(p.getPagePar()+this.DefBoost);
    }
    public int BuffDuration(){
        return this.dureeEffet;
    }
    public void SetBuffDuration(int b){
        this.dureeEffet=b;
    }
    public void DebuffAfterEnd(Joueur j){
        Personnage p = j.getPersonnage();
        p.setPtPar(p.getPagePar()-this.DefBoost);
    }
    public int getBuffDetails(){
        return this.DefBoost;
    }
    
    /**
     * methode de sauvegarde dans la BDN
     * @param connection: connection à la BDN
     * @param ID_sauvegarde: identifiant de la sauvegarde
     * @param i: incrément i
     */


    public void saveToDatabase(Connection connection, int ID_sauvegarde, int i) {
    try {
        // Requête pour insérer un objet dans la table "Objet"
        String query = "INSERT INTO Objet(nom_objet, XP, x, y) VALUES (?, ?, ?, ?)";
        PreparedStatement stm = connection.prepareStatement(query);
        
        // Définir les paramètres pour la requête
        stm.setString(1, "Miel" + i);          // nom_objet (ex: 'Miel1')
        stm.setInt(2, this.XP);                // XP (expérience de l'objet)
        stm.setInt(3, this.pos.getX());        // x (coordonnée X)
        stm.setInt(4, this.pos.getY());        // y (coordonnée Y)

        // Exécuter la requête
        stm.executeUpdate();

        // Confirmation dans la console
        System.out.println("Nourriture nom: Miel" + i + " à la position: [" + this.pos.getX() + "," + this.pos.getY() + "]");
        } catch (SQLException ex) {
        Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    /**
     * methode de chargement de la BDN
     * @param connection: connection à la BDN
     * @param id: identifiant de la sauvegarde
     * @param nom_objet: nom objet
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
            
            System.out.println("Nom de la nourriture : " + nom_objet + " Position: [" + this.pos.getX() + ", " + this.pos.getY() + "] XP: " + this.XP);
        } else {
            System.out.println("Aucune nourriture trouvée avec le nom: " + nom_objet);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
}
