/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 */
public class TestPoint2D {
    public static void main(String[] args){
        Point2D O = new Point2D();
        Point2D i = new Point2D(1, 0);
        Point2D j = new Point2D(0, 1);
        Point2D P1 = new Point2D(3,4);
        Point2D P2 = new Point2D(P1);
        O.getX();
        O.getY();
        i.afficher();
        j.afficher();
        P1.afficher();
        P2.afficher();
        P2.setX(2);
        P2.setY(2);
        System.out.println("P2");
        P2.afficher();
        
        P2.setPosition(5, 5);
        P2.afficher();
        
        P2.translater(-2, -2);
        P2.afficher();
           
    }
    
}
