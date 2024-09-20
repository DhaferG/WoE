/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

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
    this.archer= new Archer();
    this.paysan= new Paysan();
    this.lapin= new Lapin();
    }

    // Méthode pour créer un monde avec des positions aléatoires pour chaque protagoniste
    public void creeMondeAlea() {
        Random rand = new Random();
        Set<Point2D> positions = new HashSet<>(); // Pour stocker les positions déjà utilisées
        
        // Positionner l'archer
        Point2D posArcher = genererPositionUnique(positions, rand);
        archer.setPosition(posArcher);

        // Positionner le paysan
        Point2D posPaysan = genererPositionUnique(positions, rand);
        paysan.setPosition(posPaysan);

        // Positionner le lapin
        Point2D posLapin = genererPositionUnique(positions, rand);
        lapin.setPosition(posLapin);
    }

    // Méthode pour générer une position unique (non présente dans 'positions')
    private Point2D genererPositionUnique(Set<Point2D> positions, Random rand) {
        Point2D pos;
        do {
            int x = rand.nextInt(100); // Coordonnées entre 0 et 99 (modifiable)
            int y = rand.nextInt(100);
            pos = new Point2D(x, y);
        } while (positions.contains(pos)); // S'assurer que la position est unique
        positions.add(pos); // Ajouter la nouvelle position au set
        return pos;
    }

    // Méthode pour afficher les positions des protagonistes
    public void afficherMonde() {
        System.out.println("Archer position: ");
        archer.getPosition().afficher();

        System.out.println("Paysan position: ");
        paysan.getPosition().afficher();

        System.out.println("Lapin position: ");
        lapin.getPosition().afficher();
    }
}
  
