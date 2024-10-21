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
     * @param j: joueur
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
        stm.setString(1, "PotionSoin" + i);          // nom_objet (ex: 'Miel1')
        stm.setInt(2, this.XP);                // XP (expérience de l'objet)
        stm.setInt(3, this.pos.getX());        // x (coordonnée X)
        stm.setInt(4, this.pos.getY());        // y (coordonnée Y)

        // Exécuter la requête
        stm.executeUpdate();

        // Confirmation dans la console
        System.out.println("PotionSoin nom: PotionSoin" + i + " à la position: [" + this.pos.getX() + "," + this.pos.getY() + "]");
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
            
            System.out.println("Nom de la potion soin : " + nom_objet + " Position: [" + this.pos.getX() + ", " + this.pos.getY() + "] XP: " + this.XP);
        } else {
            System.out.println("Aucune potion soin trouvée avec le nom: " + nom_objet);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
