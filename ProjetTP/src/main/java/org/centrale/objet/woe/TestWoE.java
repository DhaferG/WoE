/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 */
public class TestWoE {
    
    public static void main(String[] args){
        
        World monde= new World();
        monde.creeMondeAlea();
        // positions initiales de robin, peon and bugs
        System.out.println("position initiale de robin");
        monde.robin.getPos().afficher();
        System.out.println("position initiale de peon");
        monde.peon.getPos().afficher();
        System.out.println("position initiale de bugs");
        monde.bugs.getPos().afficher();
        
        // position deplacée aléatoirement de robin, peon and bugs
        System.out.println("position deplacée de robin");
        monde.robin.deplace();
        monde.robin.getPos().afficher();
        
        System.out.println("position deplacée de peon");
        monde.peon.deplace();
        monde.peon.getPos().afficher();
        
        System.out.println("position deplacée de bugs");
        monde.bugs.deplace();
        monde.bugs.getPos().afficher();
        
    
    }
    
}
