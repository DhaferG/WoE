package org.centrale.objet.woe;

public class PotionSoin extends Objet{
    public int health;
    public PotionSoin(Point2D pos,int pts,int health) {
        super(pos, pts);
        this.health = health;
    }
    
    /** 
     * @param c
     */
    public void consume(Personnage c){
        if ((c.pos.getX()==this.pos.getX()) && (c.pos.getX()==this.pos.getX())){
            c.ptVie+=this.health;
        }
        else{
            System.out.println("Potion not found");
        }
    }
}
