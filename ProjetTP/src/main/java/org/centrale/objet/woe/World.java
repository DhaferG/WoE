/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Random;

/**
 * Classe World : permet la creation et la manipulation d'un monde
 * @author nourkouki
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
    
    }

    // Méthode pour créer un monde avec des positions aléatoires pour chaque protagoniste
    
    /**
     * méthode permet de créer un monde avec des positions aléatoires distinctes 
     * pour chaque protagoniste dans un espace 10x10
     * Les positions sont attribuées de manière aléatoire aux personnages.
     */
    public void creeMondeAlea() {
        // generer une liste de positions aléatoires distinctes dans un espace 10x10
        final int[] positions = new Random().ints(1, 10).distinct().limit(10).toArray();
        // Attribuer les positions aux personnages
        robin.pos = new Point2D(positions[0], positions[1]);
        peon.pos = new Point2D(positions[2], positions[3]);
        bugs.pos = new Point2D(positions[4], positions[5]);
        GuillaumeT=new Archer(robin);
        grosBill.pos= new Point2D(positions[6], positions[7]);
        wolfie.pos= new Point2D(positions[8], positions[9]);
        
 
    }
    
    public void tourDeJeu(){
    
    }
    
    public void afficheWorld(){
        
    }

}
  
