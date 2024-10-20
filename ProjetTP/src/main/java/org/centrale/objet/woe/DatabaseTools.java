/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author nourkouki
 */
public class DatabaseTools {
    private String login;
    private String password;
    private String url;
    Connection connection;

    /**
     * Load infos
     */
    public DatabaseTools() {
        try {
            // Get Properties file
            ResourceBundle properties = ResourceBundle.getBundle(DatabaseTools.class.getPackage().getName() + ".database");

            // USE config parameters
            login = properties.getString("login");
            password = properties.getString("password");
            String server = properties.getString("server");
            String database = properties.getString("database");
            url = "jdbc:postgresql://" + server + "/" + database;

            // Mount driver
            Driver driver = DriverManager.getDriver(url);
            if (driver == null) {
                Class.forName("org.postgresql.Driver");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.connection = null;
    }
    
    /**
     * Get connection to the database
     */
    public void connect() {
        if (this.connection == null) {
            try {
                this.connection = DriverManager.getConnection(url, login, password);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Disconnect from database
     */
    public void disconnect() {
        if (this.connection != null) {
            try {
                this.connection.close();
                this.connection = null;
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * get Player ID
     * @param nomJoueur
     * @param password
     * @return playerID
     */
    public Integer getPlayerID(String nomJoueur, String password) {
        Integer playerID = null;
        try {
            String query ="SELECT nom_code from joueur where  nom_joueur=? and mdp=?";
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, nomJoueur);
            stmt.setString(2, password);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                    String nomCode = res.getString("nom_code");
                    System.out.println("playerID : " + nomCode);
                    
                    // Convertir la valeur en entier si c'est un nombre
                    playerID = Integer.valueOf(nomCode);
            }
            stmt.close() ;
        }
            
        catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playerID;
    }
    
    /**
     * methode save world permet de sauvegarder les informations de WoE dans notre base de données
     *
     * @param idJoueur
     * @param nomPartie
     * @param nomSauvegarde
     * @param monde
     */
        
    public void saveWorld(Integer idJoueur, String nomPartie, String nomSauvegarde, World monde) {
    try {
        String query_id = "SELECT MAX(id_monde) as max_id from monde";
        PreparedStatement stmtid = this.connection.prepareStatement(query_id);
        ResultSet max = stmtid.executeQuery();
        Integer id = 0;
        if (max.next()){
           id = max.getInt("max_id");
        }
        String query_monde = "INSERT INTO monde (id_monde,nom_monde,dim_x,dim_y) " +
                   "VALUES (?,?,?,?)";
        PreparedStatement stmtMonde = this.connection.prepareStatement(query_monde);
        stmtMonde.setInt(1,id+1);
        stmtMonde.setString(2, "My World");
        stmtMonde.setInt(3, monde.getTailleMonde());
        stmtMonde.setInt(4, monde.getTailleMonde());
        stmtMonde.executeUpdate();
        String sauv_id = "SELECT MAX(id_sauvegarde) as max_id from sauvegarde";
        PreparedStatement stmtsauv = this.connection.prepareStatement(sauv_id);
        ResultSet r = stmtsauv.executeQuery();
        Integer sauveg = 0;
        if (r.next()){
            sauveg = r.getInt("max_id");
        }
        boolean quicksave = false;
        if ("".equals(nomSauvegarde)){
            quicksave = true;
        }
        String query = "INSERT INTO sauvegarde (id_sauvegarde,nom, date,est_sauv_rapide) " +
                    "VALUES (?, ?, ?,?)";
       
       
        PreparedStatement stmtsauve = this.connection.prepareStatement(query);
        stmtsauve.setInt(1, sauveg+1);
        stmtsauve.setString(2, nomSauvegarde);
        stmtsauve.setTimestamp(3,new Timestamp(System.currentTimeMillis()) );
        stmtsauve.setBoolean(4,quicksave);
        stmtsauve.executeUpdate();


        String partie_id = "SELECT MAX(id_partie) as max_id from partie";
        PreparedStatement stmtpart = this.connection.prepareStatement(partie_id);
        ResultSet rs = stmtpart.executeQuery();
        Integer part = 0;
        if (rs.next()){
            part = rs.getInt("max_id");
        }
        String querypartie  = "INSERT INTO partie (id_partie,nom_partie,date_deb,date_fin,id_monde,nom_code,id_sauvegarde) " +
                    "VALUES (?, ?, ?,?,?,?,?)";
       
       
        PreparedStatement stmtpartie = this.connection.prepareStatement(querypartie);
        stmtpartie.setInt(1, part+1);
        stmtpartie.setString(2, nomPartie);
        stmtpartie.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        stmtpartie.setTimestamp(4, new Timestamp(System.currentTimeMillis()+36000));
        stmtpartie.setInt(5,id+1);
        stmtpartie.setInt(6,idJoueur);
        stmtpartie.setInt(7,sauveg+1);
        stmtpartie.executeUpdate();


    }
    catch (SQLException ex) {
        Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }
    }


    /**
     * get world from database
     *
     * @param idJoueur
     * @param nomPartie
     * @param nomSauvegarde
     * @param monde
     */
    public void readWorld(Integer idJoueur, String nomPartie, String nomSauvegarde, World monde) {
        try {
            String Query = String.format("SELECT a.*,s.nom from public.partie a\r\n" + //
                                "JOIN public.sauvegarde s on a.id_sauvegarde = s.id_sauvegarde\r\n" + //
                                "WHERE s.nom=? and a.nom_code=? and a.nom_partie =?" );
            PreparedStatement stmt = this.connection.prepareStatement(Query);
            stmt.setString(1, nomSauvegarde);
            stmt.setString(2, String.valueOf(idJoueur));
            stmt.setString(3,nomPartie);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                System.out.println("Id_sauvegarde est "+res.getInt("id_sauvegarde"));
                System.out.println("Id_partie est "+res.getInt("id_partie"));
            }
        } catch (SQLException ex) {
                Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
