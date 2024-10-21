package org.centrale.objet.woe;

import java.util.ArrayList;


/**
 * la classe Inventaire gère l'inventaire du joueur humain
 * @author nourkouki
 * @author dghanmi
 */
public class Inventaire {
    // attributs
    private ArrayList<Objet> objets;   
    private static final int MAX_OBJETS = 6; 

    /**
     * constructeur par defaut
     */
    public Inventaire() {
        objets = new ArrayList<>(MAX_OBJETS); 
    }

    // Add an objet to the inventory
    /**
     * Add an objet to the inventory
     * @param objet: objet
     * @return  boolean
     */
    public boolean addObjet(Objet objet) {
        if (objets.size() < MAX_OBJETS) {
            objets.add(objet); 
            return true;
        } else {
            System.out.println("Inventory is full. Cannot add more objects.");
            return false;
        }
        
    }

    // Remove an objet from the inventory at a specific slot
    /**
     * Remove an objet from the inventory at a specific slot
     * @param slot : slot
     */
    public void removeObjet(int slot) {
        if (slot >= 0 && slot < objets.size()) {
            Objet removedObjet = objets.remove(slot);
            System.out.println(removedObjet.getNom() + " removed from slot " + slot);
        } else {
            System.out.println("Slot " + slot + " is empty or out of bounds.");
        }
    }

    // Display all objects in the inventory
    /**
     * Display all objects in the inventory
     * @return 
     */
    public String displayInventory() {
        if (this.objets.isEmpty()) {
            return "Inventory is empty.";
        } 
        else if (objets == null){
            return "Empty";
        }
        else {
            String s= "Player's Inventory:";
            for (int i = 0; i < objets.size(); i++) {
                s+= "Slot " + i + ": ";
                s+=objets.get(i).affiche();
            }
            return s;
        }
    }
    /**
     * get objet
     * @param slot: slot
     * @return 
     */

    public Objet getObjet(int slot) {
        if (slot >= 0 && slot < objets.size()) {
            return objets.get(slot);
        } else {
            System.out.println("Slot " + slot + " is out of bounds.");
            return null;
        }
    }
}
