package org.centrale.objet.woe;

import java.sql.Connection;

/**
 * Classe Objet gérant les objets
 * @author nourkouki
 * @author dghanmi
 */
public abstract class Objet extends ElementDeJeu{
    // Attributs de la classe
     /** 
      * position de l'objet
      */
    /**
     * Points expérience gagnés grâce à l'objet
     */
    public int XP;
    // constructeur
    /**
     * Constructeur de la classe Objet
     * @param pos: position de l'objet
     * @param XP: Points expérience gagnés grâce à l'objet
     * @param nom: nom de l'objet
     */
    public Objet (Point2D pos,int XP, String nom) {
        super(pos);
        this.setNom(nom);
        this.XP=XP;
    }
    public String affiche(){
        System.out.println(nom);
        return nom;
    }
    
    
}
