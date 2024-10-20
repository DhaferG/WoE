package org.centrale.objet.woe;

import java.util.HashMap;
/**
 * la classe Inventaire gère l'inventaire du joueur humain
 * @author nourkouki
 * @author dghanmi
 */

public class Inventaire {
    private HashMap<Integer, Objet> Objets; 
    private static final int MAX_ObjetS = 6; 

    // Constructor
    public Inventaire() {
        Objets = new HashMap<>();
    }
    public void addObjet(int slot, Objet Objet) {
        if (Objets.size() < MAX_ObjetS) {
            if (!Objets.containsKey(slot)) {
                Objets.put(slot, Objet);
            } else {
                System.out.println("Slot " + slot + " is already occupied.");
            }
        } else {
            System.out.println("Inventory is full. Cannot add more Objets.");
        }
    }

    // Remove an Objet from the inventory
    public void removeObjet(int slot) {
        if (Objets.containsKey(slot)) {
            Objet removedObjet = Objets.remove(slot);
        } else {
            System.out.println("Slot " + slot + " is empty.");
        }
    }

    // Display all Objets in the inventory
    public void displayInventory() {
        if (Objets.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Player's Inventory:");
            for (int slot : Objets.keySet()) {
                System.out.print("Slot " + slot + ": ");
                // TODO : Methode Affiche pour Objet
            }
        }
    }

    // Get Objet from a specific slot
    public Objet getObjet(int slot) {
        return Objets.get(slot);
    }
}