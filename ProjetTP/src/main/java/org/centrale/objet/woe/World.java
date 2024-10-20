/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
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
    private HashMap<Point2D,Combattant> EnemyCreats;
    private HashMap<Point2D,NuageToxique> Nuages;
    public HashMap<Point2D,ElementDeJeu> elems;
    /**
     * Matrice pour représenter l'espace de jeu
     */
    private ElementDeJeu[][] espaceJeu;
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
    
    public void RandomElements(HashMap<Point2D,ElementDeJeu> a, int n){
        Random rand = new Random();
        int m = rand.nextInt(n)+40;
        final int[] positions = new Random().ints(0, 50).limit(m+1).toArray();
        for (int i=0;i<m;i++){
            int d = rand.nextInt(101);
            if (d<8){
                Point2D p = new Point2D(positions[i], positions[i+1]);
                Guerrier g = new Guerrier(300,10,15,50,20,1,p);
                a.put(p, g);
                this.EnemyCreats.put(p, g);
                espaceJeu[positions[i]][positions[i+1]]=g;
            }
            else if (d<20){
                Point2D p= new Point2D(positions[i], positions[i+1]);
                Archer arch =new Archer(200,15,10,60,5,4,p,20);
                a.put(p,arch);
                this.EnemyCreats.put(p,arch);
                espaceJeu[positions[i]][positions[i+1]]=arch;
            }
            else if (d<28){
                Point2D s = new Point2D(positions[i], positions[i+1]);
                Paysan p = new Paysan("Villager",100,0,0,0,0,0,s);
                a.put(s,p);
                espaceJeu[positions[i]][positions[i+1]]=p;
            }
            else if (d<38){
                Point2D p = new Point2D (positions[i], positions[i+1]);
                Loup l = new Loup(250,20,0,40,0,p,"Wolf");
                a.put(p,l);
                this.EnemyCreats.put(p,l);
                espaceJeu[positions[i]][positions[i+1]]=l;
            }
            else if (d<46){
                Point2D p = new Point2D(positions[i], positions[i+1]);
                Lapin l = new Lapin(50,0,0,0,0,p,"Rabbit");
                l.setNom("Bugs");
                a.put(new Point2D(positions[i],positions[i+1]),l);
                espaceJeu[positions[i]][positions[i+1]]=l;
            }
            else if (d<70){
                Point2D pos = new Point2D(positions[i], positions[i+1]);
                int h = rand.nextInt(50)+50;
                PotionSoin p = new PotionSoin(pos , h);
                a.put(pos,p);
                espaceJeu[positions[i]][positions[i+1]]=p;
            }
            else if (d<85){
                Point2D pos = new Point2D(positions[i], positions[i+1]);
                int h = rand.nextInt(60)+12;
                Epee p = new Epee(pos , h, 6);
                a.put(pos,p);
                espaceJeu[positions[i]][positions[i+1]]=p;
            }
            else if (d<95){
                Point2D pos = new Point2D(positions[i], positions[i+1]);
                int h = rand.nextInt(60)+12;
                Nourriture p = new Nourriture(pos,h,6);
                a.put(pos,p);
                espaceJeu[positions[i]][positions[i+1]]=p;
            }
            else{
                Point2D pos = new Point2D(positions[i], positions[i+1]);
                int h = rand.nextInt(60)+12;
                NuageToxique p = new NuageToxique(pos,h , 3);
                a.put(pos,p);
                this.Nuages.put(pos,p);
                espaceJeu[positions[i]][positions[i+1]]=p;
            }
        }
    }
    
    // constructeur du monde
    
    // /**
    //  * Constructeur par défaut de la classe World
    //  */
    
    public World() {
        this.espaceJeu = new ElementDeJeu[TAILLE_MONDE][TAILLE_MONDE];
        this.elems = new HashMap<>();
        this.Nuages = new HashMap<>();
        this.EnemyCreats = new HashMap<>();
    }
    /**
     * méthode permet d'initialiser l'espace de jeu avec des cases vides
     */
    
    
    // Méthode pour créer un monde avec des positions aléatoires pour chaque protagoniste
    /**
     * méthode permet de créer un monde avec des positions aléatoires distinctes 
     * pour chaque protagoniste dans un espace 50x50
     * Les positions sont attribuées de manière aléatoire aux personnages.
     * @param n: nombre de personnage
     */
    public void creeMondeAlea(int n) {
        RandomElements(this.elems, n);
    }
    public ElementDeJeu inposition(int i, int j){
        return this.espaceJeu[i][j];
    }
    
    public void dropElement(int x, int y){
        this.espaceJeu[x][y]=null;
        this.elems.remove(new Point2D(x,y));
        this.EnemyCreats.remove(new Point2D(x,y));
    }
    public void update(Joueur player){
        Random r = new Random();
        for (ElementDeJeu c:this.elems.values()){
            if (c instanceof Deplacable){
                int dx=r.nextInt(3)-1;
                int dy=r.nextInt(3)-1;
                Point2D p = c.pos;
                this.espaceJeu[p.getX()][p.getY()]=null;
                ((Deplacable)c).deplace(this,dx,dy);
                this.espaceJeu[c.pos.getX()][c.pos.getY()]=c;
            }
        }
        this.elems.clear();
        this.EnemyCreats.clear();
        this.Nuages.clear();
        for (int i=0;i<TAILLE_MONDE;i++){
            for (int j=0; j<TAILLE_MONDE;j++){
            if (!(this.espaceJeu[i][j]==null)){
                this.elems.put(new Point2D(i,j), this.inposition(i, j));
                if (this.espaceJeu[i][j] instanceof Combattant) {
                    this.EnemyCreats.put(new Point2D(i,j),(Combattant) this.inposition(i, j));
                }
                if (this.espaceJeu[i][j] instanceof NuageToxique) {
                    this.Nuages.put(new Point2D(i,j),(NuageToxique) this.inposition(i, j));
                }
            }
            }
        }
        for (Combattant c: this.EnemyCreats.values()){
            if (c instanceof Loup){
                ((Loup)c).combattre((Creature)player.getPersonnage());
            }
            if (c instanceof Guerrier){
                ((Guerrier)c).combattre((Creature)player.getPersonnage());
            }
            if (c instanceof Archer){
                ((Archer)c).combattre((Creature)player.getPersonnage());
            }
        }
        for (NuageToxique n:this.Nuages.values()){
            n.Debuff(player);
        }

    }
    
    
    public void affiche(){
        for (ElementDeJeu elem : this.elems.values()) {
            System.out.println(elem.getClass().getSimpleName());
            System.out.println("--Position:");
            elem.pos.afficher();
        }
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

}
  
