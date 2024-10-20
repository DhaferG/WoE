package org.centrale.objet.woe;

/**
 * Sous classe d'objet gérant les épées
 * @author nourkouki
 * @author dghanmi
 */
public class Epee extends Objet implements Utilisable{
    /**
     * Attribut de la class
     * degAtt: pts de Vie que la potion donne
     */
    private int degAtt;
    private int dureeEffet;
   /**
    * Constructeur à partir de deux paramètres et la classe Objet
    * @param pos: position de l'objet
    * @param pts: Points expérience gagnés grâce à l'objet - Peut être ignoré pour le moment
    * @param degAtt: degats d'attaque
    */
    public Epee(Point2D pos,int degAtt,int dureeEffet) {
        super(pos, 10,"");
        this.degAtt = degAtt;
        this.dureeEffet = dureeEffet;
    }
    public void use(Joueur j){
        Personnage p = j.getPersonnage();
        p.setDegAtt(p.getDegAtt()+this.degAtt);
    }
    public int BuffDuration(){
        return this.dureeEffet;
    }
    public void SetBuffDuration(int b){
        this.dureeEffet=b;
    }
    public void DebuffAfterEnd(Joueur j){
        Personnage p = j.getPersonnage();
        p.setDegAtt(p.getDegAtt()-this.degAtt);
    }
    public int getBuffDetails(){
        return this.degAtt;
    }
    
}
