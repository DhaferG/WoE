/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
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
        System.out.println("[" + x + ", " + y + "]");
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
    
}

    
