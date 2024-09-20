/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Random;
/**
 *
 * @author nourkouki
 */
public class World {
    public Archer robin;
    public Paysan peon;
    public Lapin bugs;
    
    // constructeur du monde
    
    public World() {
    this.robin= new Archer();
    this.peon= new Paysan();
    this.bugs= new Lapin();
    }

    // Méthode pour créer un monde avec des positions aléatoires pour chaque protagoniste
    public void creeMondeAlea() {
        // generer une liste de positions aléatoires distinctes dans un espace 10x10
        final int[] positions = new Random().ints(1, 10).distinct().limit(6).toArray();
        // Attribuer les positions aux personnages
        robin.pos = new Point2D(positions[0], positions[1]);
        peon.pos = new Point2D(positions[2], positions[3]);
        bugs.pos = new Point2D(positions[4], positions[5]);
 
    }

}
  
