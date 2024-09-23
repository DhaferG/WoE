package org.centrale.objet.woe;

public class PotionSoin extends Objet{
    
    /**
     * Attribut de la class
     * health: pts de Vie que la potion donne
     */
    /** Constructeur de la classe sous-classe d'objet avec les paramètres
     * @param pos: position de la potion
     * @param pts: points à gagner en trouvant la potion
     */
    public int health;
    public PotionSoin(Point2D pos,int pts,int health) {
        super(pos, pts);
        this.health = health;
    }
    
    /** 
     * Méthode permettant d'utiliser la potion
     * @param c: personnage qui consomme la potion
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
