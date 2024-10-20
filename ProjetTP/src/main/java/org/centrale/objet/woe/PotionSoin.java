package org.centrale.objet.woe;

/**
 * sous classe d'objet gérant les potions de soins
 * @author nourkouki
 * @author dghanmi
 */

public class PotionSoin extends Objet{
    
    /**
     * Attribut de la class
     * health: pts de Vie que la potion donne
     */
    public int health;
    public PotionSoin(Point2D pos,int health) {
    /** Constructeur de la classe PotionSoin sous-classe d'objet avec les paramètres
     * @param pos: position de la potion
     * @param pts: points à gagner en trouvant la potion
     */
        super(pos, 10,"Potion");
        this.health = health;
    }
    
    /** 
     * Méthode permettant d'utiliser la potion
     * @param c: personnage qui consomme la potion
     */
    public void consume(Joueur j){
        if (j.getPersonnage().getPtVie()==j.getMaxHealth()){
            System.out.println("Potion Wasted");
        }
        else{
            j.getPersonnage().setPtVie(Math.min(j.getPersonnage().getPtVie()+this.health,j.getMaxHealth()));
        }
    }
}
