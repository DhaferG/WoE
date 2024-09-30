/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Random;

/**
 *
 * @author nourkouki
 * @author dghanmi
 */
public class World {
    //Attributs de la classe
    /**
     * Robin un Personnage Archer dans le monde
     */
    public Archer robin;
    
    /**
     * GuillaumeT un autre Archer dans le monde initialisé à partir de robin
     */
    public Archer GuillaumeT;
    
    /**
     * peon un Personnage Paysan dans le monde
     */
    public Paysan peon;
    
    /**
     * Bugs un Monstre Lapin dans le monde
     */
    public Lapin bugs;
    
    /**
     * grosBill un Guerrier dans le monde
     */
    public Guerrier grosBill;
    
    /**
     * wolfie un monstre loup dans le monde
     */
    public Loup wolfie;
    
    public PotionSoin potion;
    /**
     * Matrice pour représenter l'espace de jeu
     */
    private int[][] espaceJeu;
    /**
     * Taille par défaut d'un monde carré 50x50
     */
    
    private static final int TAILLE_MONDE = 50; 
    // constructeur du monde
    
    /**
     * Constructeur par défaut de la classe World
     */
    
    public World() {
    this.robin= new Archer();
    this.GuillaumeT=new Archer(robin);
    this.peon= new Paysan();
    this.bugs= new Lapin();
    this.grosBill= new Guerrier();
    this.wolfie= new Loup();
    this.potion= new PotionSoin(new Point2D(5,5), 0, 50);
    this.espaceJeu = new int[TAILLE_MONDE][TAILLE_MONDE]; // Espace de 50x50
    
    }
    // ici on implemente la méthode qui évitera ue deux protagonistes se trouve dans la même position
    
    /**
     * méthode permet d'initialiser l'espace de jeu avec des cases vides
     */
    
    // Initialise l'espace de jeu avec des cases vides (-3)
    public void initialiserEspace() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                espaceJeu[i][j] = -3;  // -3 représente une case vide
            }
        }
    }
    
    
    // Méthode pour créer un monde avec des positions aléatoires pour chaque protagoniste
    /**
     * méthode permet de créer un monde avec des positions aléatoires distinctes 
     * pour chaque protagoniste dans un espace 50x50
     * Les positions sont attribuées de manière aléatoire aux personnages.
     */
    public void creeMondeAlea() {
        // generer une liste de positions aléatoires distinctes dans un espace 50x50
        final int[] positions = new Random().ints(1, TAILLE_MONDE).distinct().limit(10).toArray(); //bug with 1 to 9 as bounds for 10 distinct ints
        // Attribuer les positions aux personnages
        robin.pos = new Point2D(positions[0], positions[1]);
        peon.pos = new Point2D(positions[2], positions[3]);
        bugs.pos = new Point2D(positions[4], positions[5]);
        GuillaumeT=new Archer(robin);
        grosBill.pos= new Point2D(positions[6], positions[7]);
        wolfie.pos= new Point2D(positions[8], positions[9]);

 
    }
    
    // Marque la position comme occupée en fonction du type d'objet
    private void marquerPosition(Creature c) {
        int x = (int) c.pos.getX();
        int y = (int) c.pos.getY();
        
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
    }
    
    public void tourDeJeu(){
    
    }
    
    public void afficheWorld(){
        
    }

}
  
