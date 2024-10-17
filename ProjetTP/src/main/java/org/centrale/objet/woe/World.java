/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * La classe World permet de creer un monde
 * @author nourkouki
 * @author dghanmi
 */

public class World {
    //Attributs de la classe
    /**
     * liste de monstres
     */
    public ArrayList<Monstre> monstres;
    /**
     * liste de personnages
     */
    public ArrayList<Personnage> personnages;
    /**
     * liste d'objets
     */
    public ArrayList<Objet> objets;
    /*
     * Array List and linked list for performance comparison
     */
    public ArrayList<Creature> creatures ;
    public LinkedList<Creature> creaturesll;
    
    /**
     * Matrice pour représenter l'espace de jeu
     */
    private int[][] espaceJeu;
    /**
     * Taille par défaut d'un monde carré 50x50
     */
    
    private static final int TAILLE_MONDE = 50;
    
    // Getter pour accéder à taille_monde
    public int getTailleMonde() {
        return TAILLE_MONDE;
    }
    
    /**
     * méthode permettant d'ajouter des créatures au tableau crétaure
     * @param c: tableau personnages
     * @param u: le nombre d'éléments dans le tableau
     */
    
    public void RandomCreatures(ArrayList<Creature> c, int u){
       Random rand= new Random();
       int x = rand.nextInt(u - 50) + 51; // Génére toujours au moins 51 créatures
        for (int i=0;i<x;i++){
            int d = rand.nextInt(100);
            // Génération aléatoire de personnages
            if (d<20){
                Guerrier g = new Guerrier();
                g.ptVie=100;
                g.nom="Guerrier";
                c.add(g);
            }
            else if (d<50){
                Archer arch =new Archer();
                arch.ptVie=80;
                arch.nom="Archer";
                c.add(arch);
            }
            else if (d<70){
                c.add(new Paysan());
            }
            // Génération aléatoire de personnages
            else if (d<85){
                c.add(new Loup());
            } else {
                c.add(new Lapin());
            }
          
        }
    }
    
    /**
     * méthode permettant d'ajouter des personnages de type Archer, Guerrier et Paysan au tableau personnages
     * @param a: tableau personnages
     * @param u: le nombre d'éléments dans le tableau
     */
    public void RandomCharacters(ArrayList<Personnage> a, int u){
        Random rand = new Random();
        int x = rand.nextInt(u);
        for (int i=0;i<x;i++){
            int d = rand.nextInt(100);
            if (d<20){
                Guerrier g = new Guerrier();
                g.ptVie=100;
                g.nom="Guerrier";
                a.add(g);
            }
            else if (d<50){
                Archer arch =new Archer();
                arch.ptVie=80;
                arch.nom="Archer";
                a.add(arch);
            }
            else{
                a.add(new Paysan());
            }
        }
    }
    /**
     * méthode permettant d'ajouter des monstres de type Lapin et Loup au tableau monstres
     * @param a: tableau monstres
     * @param u: le nombre d'éléments dans le tableau
     */
    public void RandomMonsters(ArrayList<Monstre> a, int u){
        Random rand = new Random();
        int x = rand.nextInt(u)+5;
        for (int i=0;i<x;i++){
            int d = rand.nextInt(100);
            if (d<30){
                a.add(new Loup());
            }
            else{
                a.add(new Lapin());
            }
        }
    }
    
    /**
     * méthode permettant d'ajouter des objets
     * @param a: tableau objets
     * @param u: le nombre d'éléments dans le tableau
     */
    public void RandomObjects(ArrayList<Objet> a, int u){
        Random rand = new Random();
        int x = rand.nextInt(u - 5) + 5; // Générer au moins 5 objets
        for (int i=0;i<x;i++){
            int d = rand.nextInt(100);
            if (d<30){
                a.add(new Epee(new Point2D(0,0),0,0));
            }
            else{
                a.add(new PotionSoin(new Point2D(0,0),0,0));
            }
        }
    }

    public void RandomCreature(List<Creature> a, int u){
        Random rand = new Random();
        int x = u;//rand.nextInt(u);
        for (int i=0;i<x;i++){
            int d = rand.nextInt(100);
            if (d<20){
                Guerrier g = new Guerrier();
                g.ptVie=100;
                g.nom="Guerrier";
                a.add(g);
            }
            else if (d<50){
                Archer arch =new Archer();
                arch.ptVie=80;
                arch.nom="Archer";
                a.add(arch);
            }
            else{
                a.add(new Paysan());
            }
        }
    }


    
    // constructeur du monde
    
    // /**
    //  * Constructeur par défaut de la classe World
    //  */
    
    public World() {
        this.espaceJeu = new int[TAILLE_MONDE][TAILLE_MONDE];
        this.personnages = new ArrayList<>();
        this.monstres = new ArrayList<>();
        this.objets = new ArrayList<>();
        this.creatures = new ArrayList<>();
        this.creaturesll = new LinkedList<>();
        
        RandomCreatures(creatures, 100); 
        RandomObjects(objets,10);
    }
    /**
     * méthode permet d'initialiser l'espace de jeu avec des cases vides
     */
    
    // Initialise l'espace de jeu avec des cases vides (-3)
    public void initialiserEspace() {
        for (int i = 0; i < TAILLE_MONDE; i++) {
            for (int j = 0; j < TAILLE_MONDE; j++) {
                espaceJeu[i][j] = -3;  // -3 représente une case vide
            }
        }
    }
    
    
    // Méthode pour créer un monde avec des positions aléatoires pour chaque protagoniste
    /**
     * méthode permet de créer un monde avec des positions aléatoires distinctes 
     * pour chaque protagoniste dans un espace 50x50
     * Les positions sont attribuées de manière aléatoire aux personnages.
     * @param n: nombre de personnage
     */
    public void creeMondeAlea(int n) {
        // generer une liste de positions aléatoires distinctes dans un espace 10x10
        final int[] positions = new Random().ints(0, 51).limit(100).toArray();
        // Attribuer les positions aux personnages
        int i=0;
        for (Personnage p : personnages) {
            p.pos = new Point2D(positions[i], positions[i+1]);
            i=i+1;
        }

        // Placer tous les monstres
        int j=0;
        for (Monstre m : monstres) {
            m.pos = new Point2D(positions[j], positions[j+1]);
            j=j+1;
    }
    RandomCreature(this.creatures, n);
    RandomCreature(this.creaturesll, j);
}


    
    // Marque la position comme occupée en fonction du type d'objet
    /**
     * méthode permettant de marquer la position d'un protagoniste dans l'espace de jeu
     * @param c 
     */
    public void marquerPosition(Creature c) {
        int x = (int) c.pos.getX();
        int y = (int) c.pos.getY();
        
        // Vérifier si la position est vide
        if (espaceJeu[x][y] == -3) { // -3 signifie que la case est vide
            // Identifier le type de personnage et marquer la matrice espaceJeu
            if (c instanceof Archer) {
                espaceJeu[x][y] = 0;  // 0 pour un Archer
            } else if (c instanceof Paysan) {
                espaceJeu[x][y] = 1;  // 1 pour un Paysan
            } else if (c instanceof Guerrier) {
                espaceJeu[x][y] = 2;  // 2 pour un Guerrier
            } else if (c instanceof Lapin) {
                espaceJeu[x][y] = -1; // -1 pour un Lapin
            } else if (c instanceof Loup) {
                espaceJeu[x][y] = -2; // -2 pour un Loup
            }
        } else {
            System.out.println("La case (" + x + ", " + y + ") est déjà occupée !");
        }
    }
    
    public void tourDeJeu(){
    }
    
    
    /**
     * méthode permettant d'afficher la grille de l'espace de jeu (la matrice)
     */
    public void afficheWorld(){
        for (int i = 0; i < TAILLE_MONDE; i++) {
        for (int j = 0; j < TAILLE_MONDE; j++) {
            System.out.print(espaceJeu[i][j] + " "); // Afficher chaque élément de la matrice
        }
        System.out.println(); // Nouvelle ligne après chaque ligne de la matrice
    }
        
    }
    
    /**
     * Save world to database
     *
     * @param connection
     * @param gameName
     * @param saveName
     * @param ID_sauvegarde
     */
    public void saveToDatabase(Connection connection, String gameName, String saveName, int ID_sauvegarde) {
        if (connection != null) {
            try {
                int i = 0;
                // Save world for Player ID
                for (Creature e : creatures) {
                    i++;
                    e.saveToDatabase(connection, ID_sauvegarde, i);
                }

                String Query1 = "insert into inventaire(nom_monde)values('" + gameName + "') ";
                PreparedStatement stm1 = connection.prepareStatement(Query1);
                stm1.executeUpdate();
                String Query2 = "select max(id_inventaire) as max_id_inv from inventaire ";
                PreparedStatement stm2 = connection.prepareStatement(Query2);
                ResultSet rs2 = stm2.executeQuery();
                rs2.next();

                String Query = "insert into contient_inventaire(id_inventaire,id_sauvegarde)values(" + (rs2.getInt("max_id_inv")) + "," + ID_sauvegarde + ") ";
                PreparedStatement stm = connection.prepareStatement(Query);
                stm.executeUpdate();
                int j = 0;

                for (Objet ob : objets) {
                    j++;
                    ob.saveToDatabase(connection, ID_sauvegarde, (rs2.getInt("max_id_inv")), j);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    /**
     * Get world from database
     *
     * @param connection
     * @param gameName
     * @param saveName
     */
    public void getFromDatabase(Connection connection, String gameName, String saveName) {
        if (connection != null) {
            // Remove old data

            // Get Player ID
            
            // get world for Player ID
        }
    }

}
  
