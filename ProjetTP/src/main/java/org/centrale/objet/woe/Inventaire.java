package org.centrale.objet.woe;

import java.util.ArrayList;

public class Inventaire {
    private ArrayList<Objet> objets;   
    private static final int MAX_OBJETS = 6; 

    // Constructor
    public Inventaire() {
        objets = new ArrayList<>(MAX_OBJETS); 
    }

    // Add an objet to the inventory
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
    public void removeObjet(int slot) {
        if (slot >= 0 && slot < objets.size()) {
            Objet removedObjet = objets.remove(slot);
            System.out.println(removedObjet.getNom() + " removed from slot " + slot);
        } else {
            System.out.println("Slot " + slot + " is empty or out of bounds.");
        }
    }

    // Display all objects in the inventory
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

    public Objet getObjet(int slot) {
        if (slot >= 0 && slot < objets.size()) {
            return objets.get(slot);
        } else {
            System.out.println("Slot " + slot + " is out of bounds.");
            return null;
        }
    }
}
