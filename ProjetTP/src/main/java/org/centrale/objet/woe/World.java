/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

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
        
    }

}
  
