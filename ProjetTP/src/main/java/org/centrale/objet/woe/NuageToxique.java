package org.centrale.objet.woe;

public class NuageToxique extends Objet implements Deplacable {
    int dureeEffet;
    int Debuff;
    public NuageToxique(Point2D pos, int malus, int dureeEffet){
        super(pos, 100,"");
        this.dureeEffet=dureeEffet;
        this.Debuff=malus;
    }
    public void deplace(World w, int dx, int dy){        
        int x = this.pos.getX();
        int y = this.pos.getY();
        int h = w.getTailleMonde();
        if ((x+dx<h) &&(x+dx>=0)&& (y+dy>=0)&&(y+dy<h)){
            {
                this.setPos(new Point2D(x+dx,y+dy));
            }
        }
        else{
            this.setPos(new Point2D(x,y));
        }
    }
    public int BuffDuration(){
        return this.dureeEffet;
    }
    public void SetBuffDuration(int b){
        this.dureeEffet=b;
    }
    public void Debuff(Joueur j){
        if (j.getPersonnage().pos==this.pos){
            j.getPersonnage().setDegAtt(j.getPersonnage().getDegAtt()-this.Debuff);
        }
    }
}
