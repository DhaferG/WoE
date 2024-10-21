/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.centrale.objet.woe.gui.GameGUI;

import java.awt.*;

/**
 * Permet de tester les differentes méthodes implementées dans les differentes classes de WoE
 * @author nourkouki
 * @author dghanmi
 */
public class TestWoE {
    
    
    /** 
     * @param args
     */
    // public static void main(String[] args){
    //     DatabaseTools database = new DatabaseTools();
    //     World monde = new World();
    //     // Save world
    //     database.connect();
    //     Integer playerId = database.getPlayerID("Saegusa", "Mayumi");
    //     database.saveWorld(playerId, "Partie2", "sauv2", monde);
    //     database.readWorld(playerId, "Partie1", "sauv1", monde);
    //     Point2D p = new Point2D(10,5);
    //     // Créer un Archer avec la position initialisée
    //     Archer archer= new Archer(100, 20, 50, 5, 10, 10, p, 10);
    //     // creer un Paysan
    //     Paysan paysan = new Paysan();
    //     // creer un guerrier
    //     Guerrier guer= new Guerrier(100, 20, 50, 5, 10, 10, p);
    //     // sauvegarder dans la BDN
    //     guer.saveToDatabase(database.connection, 1, 8);
    //     archer.saveToDatabase(database.connection, 2, 2);
    //     // charger de la BDN
    //     guer.getFromDatabase(database.connection, 4, "guer");
    //     archer.getFromDatabase(database.connection, 1, "archer1");
    //     // creer un loup
    //     Loup l = new Loup(100, 100, 50, 5, 10, p);
    //     // enregistrer dans la bdn pour tester l'incrementation
    //     l.saveToDatabase(database.connection, 5, 23);
    //     l.saveToDatabase(database.connection, 5, 24);
    //     l.saveToDatabase(database.connection, 5, 25);
    //     l.saveToDatabase(database.connection, 5, 26);
    //     // creer des objets, sauvegarder et les charger de la bdn
    //     Epee ep= new Epee(p, 75, 20);
    //     ep.saveToDatabase(database.connection, 0, 0);
    //     ep.getFromDatabase(database.connection, 1, "epee0");
    //     Nourriture miel=new Nourriture(p, 50,5);
    //     miel.saveToDatabase(database.connection, 0, 0);
    //     miel.saveToDatabase(database.connection, 0, 1);
    //     miel.getFromDatabase(database.connection, 1, "miel0");
                
    //     NuageToxique nuagetox= new NuageToxique(p, -20,5);
    //     nuagetox.saveToDatabase(database.connection, 0, 2);
    //     nuagetox.saveToDatabase(database.connection, 0, 1);
    //     nuagetox.getFromDatabase(database.connection, 1, "NuageToxique1");}
        
    public static void main(String[] args) {
        World world = new World();
        world.creeMondeAlea(100);
        Joueur joueurHumain = new Joueur(world);
        JFrame frame = new JFrame("World of ECN");
        frame.setLayout(new BorderLayout());
        JLabel playerInfoLabel = new JLabel();
        playerInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.LIGHT_GRAY);
        infoPanel.add(playerInfoLabel);
        GameGUI gamePanel = new GameGUI(world, joueurHumain, playerInfoLabel);
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

        
}       
