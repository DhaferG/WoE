/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

import java.util.Objects;

/**
 * Classe gérant les coordonées de position de l'ensemble des créatures de WoE
 * @author nourkouki
 * @author dghanmi
 */
public class Point2D {
    // Attributs privés
    /**
     * coordonnée x
     */
    int x;
    /**
     * coordonnée y
     */
    int y;

    // Constructeur sans paramètres (initialise les coordonnées à (0, 0))
    /**
     * constructeur par défaut
     */
    public Point2D() {
        x = 0;
        y = 0;
    }

    // Constructeur avec deux paramètres
    /**
     * constructeur
     * @param x: position x
     * @param y: position y
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Constructeur de recopie (crée un Point2D à partir d'un autre Point2D)
    /**
     * constructeur de recopie
     * @param p : position
     */
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    
    /** 
     * get position x
     * @return int
     */
    // Accesseur pour l'attribut x
    public int getX() {
        return x;
    }

    // Modificateur pour l'attribut x
    /**
     * set position x
     * @param x : position x
     */
    public void setX(int x) {
        this.x = x;
    }

    // Accesseur pour l'attribut y
    /**
     * get position y
     * @return int
     */
    public int getY() {
        return y;
    }
    // Modificateur pour l'attribut y
    /**
     * set position y
     * @param y : position y
     */
    
    public void setY(int y) {
        this.y = y;
    }

    // Méthode pour afficher les coordonnées du point
    /**
     * affciher
     */
    public void afficher() {
        System.out.println("[" + this.x + ", " + this.y + "]");
    }
    
    // set position
    /**
     * set position y
     * @param y : position y
     * @param x: position x 
     */
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }
    
    // Méthode pour translater le point (ajouter un incrément aux coordonnées)
    /**
     * translater
     * @param dx: deplacement x
     * @param dy: deplacement y
     */
    public void translater(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    // Méthode pour calculer la distance entre deux objets
    /**
     * calculer la distance entre deux objets
     * @param p : position de l'objet
     * @return distance entre deux objets
     */
    public double distance(Point2D p){
        double rc=Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
        return(rc);
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Point2D)){
            return false;
        }
        Point2D p = (Point2D) o;
        return this.x == p.x && this.y==p.y;
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.x,this.y);
    }
}

    
