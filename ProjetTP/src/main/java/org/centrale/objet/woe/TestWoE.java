/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe;

/**
 *
 * @author nourkouki
 * @author dghanmi
 */
public class TestWoE {
    
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        
        // Création du monde
        World world = new World();
        // generation des creatures
        System.out.println("creatures generées:");
        for (Creature creature : world.creatures) {
            System.out.println(creature.getClass().getSimpleName());
            System.out.println("--Position:");
            creature.pos.afficher();
        }
        // generation des objets
        System.out.println("objets générés:");
        for (Objet objet: world.objets) {
            System.out.println(objet.getClass().getSimpleName());
            System.out.println("--Position:");
            objet.pos.afficher();
        }
        // Affichage du nombre total de créatures et d'objets
        System.out.println("\nTotal de créatures générées: " + world.creatures.size());
        System.out.println("Total d'objets générés: " + world.objets.size());
            
        
        /*
        // Création du joueur avec la taille du monde
        Joueur joueurHumain = new Joueur(world);
        Creature c = new Monstre() {}; // Créature ennemie

        // Récupération du personnage choisi
        Personnage perso = joueurHumain.getPersonnage();
        perso.affiche(); // Affiche les détails du personnage
        
        // Boucle de jeu pour effectuer plusieurs tours
        for (int i = 0; i < 5; i++) {
            System.out.println("Tour " + (i+1));
            joueurHumain.choixDuJeu(c); // Chaque tour, le joueur choisit entre se déplacer ou combattre
        }
    } */
        
       /* World monde= new World();
        int[] n = {100,1000,10000,100000,1000000};
        for (int i:n){
            monde.creeMondeAlea(i);
            int hp=0;
            int hpll=0;
            long start = System.nanoTime();
            for (int j=0;j<monde.creatures.size();j++){
                hp+=monde.creatures.get(j).ptVie;
            }
            long end = System.nanoTime();
            System.out.println("Temps pour le parcours pour un ArrayList avec "+i+" personnages est :"+(end-start));
            long startll = System.nanoTime();
            for (int j=0;j<monde.creaturesll.size();j++){
                hp+=monde.creaturesll.get(j).ptVie;
            }
            long endll = System.nanoTime();
            System.out.println("Temps pour le parcours pour LinkedList avec "+i+" personnages est :"+(endll-startll));

        }*/
        
        //monde.initialiserEspace();
        
        // positions initiales de robin, peon and bugs
        /*System.out.println("position initiale de robin");
        monde.robin.pos.afficher();
        System.out.println("position initiale de peon");
        monde.peon.pos.afficher();
        System.out.println("position initiale de bugs");
        monde.bugs.pos.afficher();
        // position initiale de GuillaumeT
        System.out.println("position initiale de GuillaumeT");
        monde.GuillaumeT.pos.afficher();
        
    //     // position deplacée aléatoirement de robin, peon and bugs
    //     System.out.println("position deplacée de robin");
    //     monde.robin.deplace();
    //     monde.robin.pos.afficher();
        
    //     //System.out.println("position deplacée de peon");
    //     monde.peon.deplace();
    //     monde.peon.pos.afficher();
        
    //     //System.out.println("position deplacée de bugs");
    //     monde.bugs.deplace();
    //     monde.bugs.pos.afficher();
        
    //     // position deplacée aléatoirement de GuillaumeT
    //     System.out.println("position deplacée de GuillaumeT");
    //     monde.GuillaumeT.pos.afficher();

         Testing combat logic
         Close range combat
        monde.robin.setPos(new Point2D(0,0));
        monde.grosBill.setPos(new Point2D(0,1));
        monde.grosBill.pageAtt=60;
        monde.grosBill.degAtt=50;
        monde.grosBill.ptVie=350;
        monde.robin.pagePar=30;
        monde.robin.ptVie=250;
        monde.robin.ptPar=20;
        monde.robin.distAttMax=8;
        monde.robin.nbFleches=12;
        monde.robin.pageAtt=60;
        monde.robin.degAtt=40;
        System.out.println("Close range combat guerrier vs archer: Guerrier Attacks");
        System.out.println("Guerrier stats before attack");
        monde.robin.affiche();
        System.out.println("Archer stats before attack");
        monde.robin.affiche();
        for (int i=0;i<3;i++){
            monde.grosBill.combattre(monde.robin);
            System.out.println("Archer stats after attack");
            monde.robin.affiche();
        }
        //long range combat
        monde.robin.setPos(new Point2D(0,0));
        monde.grosBill.setPos(new Point2D(0,5));
        System.out.println("Long range combat archer vs guerrier: Archer Attacks");
        System.out.println("Guerrier stats before attack");
        monde.grosBill.affiche();
        System.out.println("Archer stats");
        System.out.println("Quiver count " + monde.robin.nbFleches);
        monde.robin.affiche();
        for (int i=0;i<3;i++){
            monde.robin.combattre(monde.grosBill);
            System.out.println("Archer stats after attack");
            System.out.println("Quiver count " + monde.robin.nbFleches);
            System.out.println("Guerrier stats after attack");
            monde.grosBill.affiche();
        }
        monde.grosBill.setPos(new Point2D(5,5));
        System.out.println("Guerrier stats after combat:");
        monde.grosBill.affiche();
        System.out.println("Potion Position");
        monde.potion.pos.afficher();
        monde.potion.consume(monde.grosBill);
        System.out.println("Guerrier stats after consuming potion:");
        monde.grosBill.affiche(); */

    

    //     // Testing combat logic
    //     // Close range combat
    //     monde.robin.setPos(new Point2D(0,0));
    //     monde.grosBill.setPos(new Point2D(0,1));
    //     monde.grosBill.pageAtt=60;
    //     monde.grosBill.degAtt=50;
    //     monde.grosBill.ptVie=350;
    //     monde.robin.pagePar=30;
    //     monde.robin.ptVie=250;
    //     monde.robin.ptPar=20;
    //     monde.robin.distAttMax=8;
    //     monde.robin.nbFleches=12;
    //     monde.robin.pageAtt=60;
    //     monde.robin.degAtt=40;
    //     System.out.println("Close range combat guerrier vs archer: Guerrier Attacks");
    //     System.out.println("Guerrier stats before attack");
    //     monde.robin.affiche();
    //     System.out.println("Archer stats before attack");
    //     monde.robin.affiche();
    //     for (int i=0;i<3;i++){
    //         monde.grosBill.combattre(monde.robin);
    //         System.out.println("Archer stats after attack");
    //         monde.robin.affiche();
    //     }
    //     //long range combat
    //     monde.robin.setPos(new Point2D(0,0));
    //     monde.grosBill.setPos(new Point2D(0,5));
    //     System.out.println("Long range combat archer vs guerrier: Archer Attacks");
    //     System.out.println("Guerrier stats before attack");
    //     monde.grosBill.affiche();
    //     System.out.println("Archer stats");
    //     System.out.println("Quiver count " + monde.robin.nbFleches);
    //     monde.robin.affiche();
    //     for (int i=0;i<3;i++){
    //         monde.robin.combattre(monde.grosBill);
    //         System.out.println("Archer stats after attack");
    //         System.out.println("Quiver count " + monde.robin.nbFleches);
    //         System.out.println("Guerrier stats after attack");
    //         monde.grosBill.affiche();
    //     }
    //     monde.grosBill.setPos(new Point2D(5,5));
    //     System.out.println("Guerrier stats after combat:");
    //     monde.grosBill.affiche();
    //     System.out.println("Potion Position");
    //     monde.potion.pos.afficher();
    //     monde.potion.consume(monde.grosBill);
    //     System.out.println("Guerrier stats after consuming potion:");
    //     monde.grosBill.affiche();
    
     /*   int characterCount=monde.personnages.size();
        int monsterCount = monde.monstres.size();
        int p=0;
        int g=0;
        int a=0;
        int l=0;
        int L=0;
        int totalHP=0;
        for (int i=0;i<characterCount;i++){
            totalHP+=monde.personnages.get(i).ptVie;
            if (monde.personnages.get(i) instanceof Paysan){
                p++;
            }
            else if (monde.personnages.get(i) instanceof Archer){
                a++;
            }
            else{
                g++;
            }
        }
        for (int i=0;i<monsterCount;i++){
            if (monde.monstres.get(i) instanceof Lapin){
                L++;
            }
            else{
                l++;
            }
        }
        System.out.println("Il existe "+p+" paysans, "+a+" archers, "+g+" guerries, "+L+" loups et "+l+" lapins.");
        System.out.println("Le total des pts vie des personnages est: "+totalHP);
       */ 
    /*
        illustration que deux personnages ne sont pas sur la meme case
        */
    
       /* monde.creeMondeAlea(10);
        for (Personnage p: monde.personnages) {
            p.pos.afficher();
        }
        monde.initialiserEspace();
        //monde.afficheWorld();
        
        for (Personnage personnage : monde.personnages) {
            monde.marquerPosition(personnage);
        
        }
        monde.afficheWorld();*/
        // test pour le constructeur de recopie après correction 
        /* Point2D position1 = new Point2D(5, 10);
        Archer archer1 = new Archer("Robin", 100, 20, 15, 10, 8, 30, position1, 20);
        System.out.println("position de archer1");
        archer1.pos.afficher();
        Archer archer2 = new Archer(archer1);
        System.out.println("position archer2");
        archer2.pos.afficher();
        System.out.println("position deplacée de archer1");
        archer1.deplace();
        archer1.pos.afficher();
        //position deplacée aléatoirement de GuillaumeT
        System.out.println("position de archer2");
        archer2.pos.afficher();*/
} }      