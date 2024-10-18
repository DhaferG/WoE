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
 *
 * @author nourkouki
 * @author dghanmi
 */
public class TestWoE {
    
    
    /** 
     * @param args
     */

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