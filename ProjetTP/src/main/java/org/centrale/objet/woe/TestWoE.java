/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

/**
 *
 * @author nourkouki
 * @author dghanmi
 */
public class TestWoE {
    
    
    /** 
     * @param args
     */
    // public static void main(String[] args){
    //     World world = new World();
    //     world.creeMondeAlea(100);
    //     world.affiche();
    //     // Affichage du nombre total de créatures et d'objets
        
            
        

    //     // Création du joueur avec la taille du monde
    //     Joueur joueurHumain = new Joueur(world);
    //     Creature c = new Monstre(); // Créature ennemie

    //     // Récupération du personnage choisi
    //     Personnage perso = joueurHumain.getPersonnage();
    //     perso.affiche(); // Affiche les détails du personnage
        
    //     // Boucle de jeu pour effectuer plusieurs tours
    //     for (int i = 0; i < 5; i++) {
    //         System.out.println("Tour " + (i+1));
    //         joueurHumain.choixDuJeu(c); // Chaque tour, le joueur choisit entre se déplacer ou combattre
    //     }
    // }
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