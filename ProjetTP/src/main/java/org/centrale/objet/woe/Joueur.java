/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe Joueur permet à un joueur humain de choisir son personnage 
 * et ses actions lors d'un tour de jeu
 * @author nourkouki
 */
public class Joueur {
    // attributs
    private Personnage p;
    private World w;
    
    //constructeurs
    public Joueur(World w) {
        this.w=w;
        this.p= choisirPersonnage();
    
    }
    //getters:
    public Personnage getPersonnage() {
        return this.p;
    }
    
    // methode choisir personnage
    /**
     * Permet au joueur humain de choisir son personnage
     * @return le personnage du joueur humain
     */
    public Personnage choisirPersonnage() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Choisissez un type de personnage jouable (Guerrier, Archer) :");
        String type = scanner.nextLine();

        System.out.println("Donnez un nom à votre personnage :");
        String nom = scanner.nextLine();
        
        // Génération de la position aléatoire en fonction de taille_monde
        int tailleMonde = w.getTailleMonde();
        Point2D position = new Point2D(rand.nextInt(tailleMonde), rand.nextInt(tailleMonde)); // Position aléatoire dans un monde de 50x50

        // Attributs communs (parade, attaque, etc.)
        int parade = rand.nextInt(50) + 10; // Génération aléatoire pour parade
        int paradeAttaque = rand.nextInt(50) + 10; // Parade à l'attaque
        int pointsVie = rand.nextInt(100) + 100; // Entre 100 et 200 PV
        int distAttMax = rand.nextInt(20) + 5; // Distance d'attaque maximale


        if (type.equalsIgnoreCase("Guerrier")) {
            int degAtt = rand.nextInt(101) + 100; // Entre 100 et 200 de dégâts
            return new Guerrier(nom, pointsVie, degAtt, parade, paradeAttaque, parade, distAttMax, position);
        } else if (type.equalsIgnoreCase("Archer")) {
            int nbFleches = rand.nextInt(20) + 10;
            int degAtt = rand.nextInt(50) + 50; // Entre 50 et 99 de dégâts car deg attaque de l'archer est toujours inférieur à celui du guerrier
            return new Archer(nom, pointsVie, degAtt, parade, paradeAttaque, parade, distAttMax, position, nbFleches);
        } else {
            System.out.println("Type de personnage non jouable. Choisissez un Guerrier ou un Archer.");
            return choisirPersonnage(); // Recommence si le type est invalide
        }
    }
    /**
     * permet à l'utilsateur de choisir soit se déplacer soit combattre
     * @param c : créature à combattre
     */
    
    public void choixDuJeu(Creature c){
        Scanner scanner = new Scanner(System.in);
        int choix=0;
        while (choix!=1 && choix!=2) {
            System.out.println("Voulez-vous (1) vous déplacer ou (2) combattre ?");
            choix = scanner.nextInt();
        
        
            if (choix == 1) {
                p.deplace(); // Appelle une méthode de déplacement
            } else if (choix == 2) {
                if (p instanceof Archer){
                    ((Archer) p).combattre(c);
                
                } else if (p instanceof Guerrier){
                ((Guerrier) p).combattre(c);
            }
            } else {
                System.out.println("choix invalide, veuillez choisir de nouveau");
            
            }
    }
    }
    
            
    
}
