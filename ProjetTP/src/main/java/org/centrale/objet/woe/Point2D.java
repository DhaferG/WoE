/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 * Classe gérant les coordonées de position de l'ensemble des créatures de WoE
 * @author nourkouki
 * @author dghanmi
 */
public class Point2D {
    // Attributs privés
    private int x;
    private int y;

    // Constructeur sans paramètres (initialise les coordonnées à (0, 0))
    public Point2D() {
        x = 0;
        y = 0;
    }

    // Constructeur avec deux paramètres
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Constructeur de recopie (crée un Point2D à partir d'un autre Point2D)
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    
    /** 
     * @return int
     */
    // Accesseur pour l'attribut x
    public int getX() {
        return x;
    }

    // Modificateur pour l'attribut x
    public void setX(int x) {
        this.x = x;
    }

    // Accesseur pour l'attribut y
    public int getY() {
        return y;
    }

    // Modificateur pour l'attribut y
    public void setY(int y) {
        this.y = y;
    }

    // Méthode pour afficher les coordonnées du point
    public void afficher() {
        System.out.println("[" + this.x + ", " + this.y + "]");
    }
    
    // set position
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }
    
    // Méthode pour translater le point (ajouter un incrément aux coordonnées)
    public void translater(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    // Méthode pour calculer la distance entre deux objets
    /**
     * 
     * @param p : position de l'objet
     * @return distance entre deux objets
     */
    public double distance(Point2D p){
        double rc=Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
        return(rc);
    }
    
}

    
