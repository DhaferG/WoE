/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;
import java.util.ArrayList;
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
    public Inventaire inventaire;
    public ArrayList<Utilisable> Buffs;
    private int Maxhealth;
    public int XP;
    public String username;
    
    //constructeurs
    /**
     * constructeur Joueur
     * @param w : monde
     */
    public Joueur(World w) {
        this.w=w;
        this.p= choisirPersonnage();
        this.inventaire = new Inventaire();
        this.Buffs = new ArrayList<>(6);
        this.XP=0;
        this.Maxhealth=this.p.getPtVie();
        this.username = username;
    
    }
    //getters:
    /**
     * get personnage
     * @return personnage
     */
    public Personnage getPersonnage() {
        return this.p;
    }
    /**
     * get max health
     * @return 
     */
    public int getMaxHealth(){
        return this.Maxhealth;
    }
    // methode choisir personnage
    /**
     * Permet au joueur humain de choisir son personnage
     * @return le personnage du joueur humain
     */
    public Personnage choisirPersonnage() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to WoE. After creating your character a graphical interface will start. Press H for how to play, P for pause and Q to quit. Enjoy!");
        System.out.println("Choisissez un type de personnage jouable (Guerrier, Archer) :");
        String type = scanner.nextLine();

        System.out.println("Donnez un nom à votre personnage :");
        this.username = scanner.nextLine();
        // Génération de la position aléatoire en fonction de taille_monde
        int tailleMonde = w.getTailleMonde();
        Point2D position = new Point2D(rand.nextInt(tailleMonde), rand.nextInt(tailleMonde)); // Position aléatoire dans un monde de 50x50

        // Attributs communs (parade, attaque, etc.)
        int parade = rand.nextInt(50) + 10; // Génération aléatoire pour parade
        int paradeAttaque = rand.nextInt(50) + 10; // Parade à l'attaque
        int pointsVie = rand.nextInt(100) + 100; // Entre 100 et 200 PV
        int distAttMax = rand.nextInt(4) + 2; // Distance d'attaque maximale

        if (type.equalsIgnoreCase("Guerrier")) {
            int degAtt = rand.nextInt(30) + 20; // Entre 100 et 200 de dégâts
            scanner.close();
            return new Guerrier(pointsVie, degAtt, parade, paradeAttaque, parade, distAttMax, position);
        } else if (type.equalsIgnoreCase("Archer")) {
            int nbFleches = rand.nextInt(20) + 10;
            int degAtt = rand.nextInt(50) + 50; // Entre 50 et 99 de dégâts car deg attaque de l'archer est toujours inférieur à celui du guerrier
            scanner.close();
            return new Archer(pointsVie, degAtt, parade, paradeAttaque, parade, distAttMax, position, nbFleches);
        } else {
            System.out.println("Type de personnage non jouable. Choisissez un Guerrier ou un Archer.");
            return choisirPersonnage();
             // Recommence si le type est invalide
        }
    }
    /**
     * permet à l'utilsateur de choisir soit se déplacer soit combattre
     */
    public void addToInventory(){
        int x = this.p.pos.getX();
        int y = this.p.pos.getY();
        if (this.w.inposition(x, y) instanceof Objet){
            if (this.inventaire.addObjet((Objet) this.w.inposition(x, y))){
            this.XP= this.XP + ((Objet)this.w.inposition(x, y)).XP;
            this.w.dropElement(x, y);
            }
        }
    }
    /**
     * 
     * @param i 
     */
    public void use(int i){
        if (i<0 ||i>5){
            System.out.println("Choix invalide");
        }
        else{
            if (inventaire.getObjet(i) instanceof PotionSoin){
                PotionSoin a = (PotionSoin) inventaire.getObjet(i);
                a.consume(this);
                this.inventaire.removeObjet(i);
            }
            if (inventaire.getObjet(i) instanceof Epee){
                Epee a = (Epee) inventaire.getObjet(i);
                a.use(this);
                this.AddBuff(a);
                this.inventaire.removeObjet(i);
            }
            if (inventaire.getObjet(i) instanceof Nourriture){
                Nourriture a = (Nourriture) inventaire.getObjet(i);
                a.use(this);
                this.AddBuff(a);
                this.inventaire.removeObjet(i);
            }
        }

    }
    /**
     * 
     */
    public void update(){
        for (Utilisable b: this.Buffs){
            b.SetBuffDuration(b.BuffDuration()-1);
        }
        this.Debuff();
    }
    /**
     * 
     * @param u 
     */
    public void AddBuff(Utilisable u){
        this.Buffs.add(u);
    }
    /**
     * 
     */
    public void Debuff(){
        for(int i=0;i<this.Buffs.size();i++){
            if (this.Buffs.get(i).BuffDuration()<=0){
                this.Buffs.get(i).DebuffAfterEnd(this);
                this.Buffs.remove(i);
            }
        }
    }
    /**
     * 
     */
    public void combattre(){
        Creature closestCreature = null;
        double minDistance = Double.MAX_VALUE;

        Point2D playerPos = this.p.pos;
        int attackRange = this.p.distAttMax;

        // Define the bounding box around the player
        int minX = playerPos.getX() - attackRange;
        int maxX = playerPos.getX() + attackRange;
        int minY = playerPos.getY() - attackRange;
        int maxY = playerPos.getY() + attackRange;

        // Iterate over all elements in the world to find creatures within the bounding box
        for (ElementDeJeu elem : this.w.elems.values()) {
            if (elem instanceof Combattant) {
                Creature creature = (Creature) elem;
                Point2D creaturePos = creature.pos;

                // Check if the creature's position is inside the bounding box
                if (creaturePos.getX() >= minX && creaturePos.getX() <= maxX &&
                    creaturePos.getY() >= minY && creaturePos.getY() <= maxY) {

                    // Calculate the actual distance between player and the creature
                    double distance = playerPos.distance(creaturePos);

                    // Check if the creature is within attack range
                    if (distance <= attackRange) {
                        // If it's the closest creature found so far, update the closest creature
                        if (distance < minDistance) {
                            minDistance = distance;
                            closestCreature = creature;
                        }
                    }
                }
            }
        }

    // If a creature was found within range, initiate combat
    if (closestCreature != null) {
    Point2D p = closestCreature.pos;
    while (closestCreature.ptVie>0){
        if (this.p instanceof Guerrier){
        ((Guerrier)this.p).combattre(closestCreature);
        }
        if (this.p instanceof Archer){
            ((Archer)this.p).combattre(closestCreature);
        }
    }
    this.w.dropElement(p.getX(),p.getY());
    this.XP+=50;
    System.out.println("Creature defeated");
    } else {
        System.out.println("Creature not found");
    }
}   
    /**
     * méthode deplace
     * 
     * @param dx: deplacement sur x
     * @param dy: deplacement sur y
     */
    public void deplacer(int dx, int dy){
        int x = this.p.pos.getX();
        int y = this.p.pos.getY();
        int h = this.w.getTailleMonde();
        if ((x+dx<h) &&(x+dx>=0)&& (y+dy>=0)&&(y+dy<h)){
            if (!(this.w.inposition(x+dx, y+dy) instanceof Creature)){
                this.p.setPos(new Point2D(x+dx,y+dy));
            }
        }
        else{
            this.p.setPos(new Point2D(x,y));
        }
    }               
}
