/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 * @author dghanmi
 */
public class TestWoE {
    
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        
        World monde= new World();
        monde.creeMondeAlea();
        monde.initialiserEspace();
        
        // positions initiales de robin, peon and bugs
        /* System.out.println("position initiale de robin");
        monde.robin.pos.afficher();
        System.out.println("position initiale de peon");
        monde.peon.pos.afficher();
        System.out.println("position initiale de bugs");
        monde.bugs.pos.afficher();
        // position initiale de GuillaumeT
        System.out.println("position initiale de GuillaumeT");
        monde.GuillaumeT.pos.afficher();
        
        // position deplacée aléatoirement de robin, peon and bugs
        System.out.println("position deplacée de robin");
        monde.robin.deplace();
        monde.robin.pos.afficher();
        
        //System.out.println("position deplacée de peon");
        monde.peon.deplace();
        monde.peon.pos.afficher();
        
        //System.out.println("position deplacée de bugs");
        monde.bugs.deplace();
        monde.bugs.pos.afficher();
        
        // position deplacée aléatoirement de GuillaumeT
        System.out.println("position deplacée de GuillaumeT");
        monde.GuillaumeT.pos.afficher();

        // Testing combat logic
        // Close range combat
        monde.robin.setPos(new Point2D(0,0));
        monde.grosBill.setPos(new Point2D(0,1));
        monde.grosBill.pageAtt=60;
        monde.grosBill.degAtt=50;
        monde.grosBill.ptVie=350;
        monde.robin.pagePar=30;
        monde.robin.ptVie=250;
        monde.robin.ptPar=20;
        monde.robin.distAttMax=8;
        monde.robin.nbFleches=12;
        monde.robin.pageAtt=60;
        monde.robin.degAtt=40;
        System.out.println("Close range combat guerrier vs archer: Guerrier Attacks");
        System.out.println("Guerrier stats before attack");
        monde.robin.affiche();
        System.out.println("Archer stats before attack");
        monde.robin.affiche();
        for (int i=0;i<3;i++){
            monde.grosBill.combattre(monde.robin);
            System.out.println("Archer stats after attack");
            monde.robin.affiche();
        }
        //long range combat
        monde.robin.setPos(new Point2D(0,0));
        monde.grosBill.setPos(new Point2D(0,5));
        System.out.println("Long range combat archer vs guerrier: Archer Attacks");
        System.out.println("Guerrier stats before attack");
        monde.grosBill.affiche();
        System.out.println("Archer stats");
        System.out.println("Quiver count " + monde.robin.nbFleches);
        monde.robin.affiche();
        for (int i=0;i<3;i++){
            monde.robin.combattre(monde.grosBill);
            System.out.println("Archer stats after attack");
            System.out.println("Quiver count " + monde.robin.nbFleches);
            System.out.println("Guerrier stats after attack");
            monde.grosBill.affiche();
        }
        monde.grosBill.setPos(new Point2D(5,5));
        System.out.println("Guerrier stats after combat:");
        monde.grosBill.affiche();
        System.out.println("Potion Position");
        monde.potion.pos.afficher();
        monde.potion.consume(monde.grosBill);
        System.out.println("Guerrier stats after consuming potion:");
        monde.grosBill.affiche(); */

    }

    
}
