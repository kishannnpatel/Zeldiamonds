package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur;

import javafx.scene.input.KeyCode;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes.Armes;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes.Epee;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi.Ennemi;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueArmes;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueCoeur;


import java.util.ArrayList;
import java.util.List;

public class Joueur extends Acteur {
    private Armes  armes;
    private VueCoeur vueCoeur;
    private boolean ramasseEpee;
    private VueArmes vueArmes;


    public Joueur(int pv, int vitesse , int degats ) {
        super(pv , vitesse , degats);
    }

    public boolean ramasseEpee() {
        return ramasseEpee;
    }


    public void ramasserArme(Epee epee, VueArmes vueArmes) {
        this.armes = epee;
        this.ramasseEpee = true;
        epee.translateXProperty().bind(this.translateXProperty());
        epee.translateYProperty().bind(this.translateYProperty().subtract(10));
        vueArmes.getImageView().setVisible(false);
        System.out.println("Épée ramassée");
    }

    public void lacherArme(VueArmes vueArmes) {
        if (ramasseEpee && armes instanceof Epee) {
            Epee epee = (Epee) armes;
            epee.translateXProperty().unbind();
            epee.translateYProperty().unbind();
            epee.setTranslateX(this.getTranslateX());
            epee.setTranslateY(this.getTranslateY() + 10);
            vueArmes.getImageView().setVisible(true);
            this.armes = null;
            this.ramasseEpee = false;
            System.out.println("Épée lâchée");
        }
    }

    // Détection de collision
    public boolean isCollision(Armes arme) {
        double distance = Math.sqrt(Math.pow(getTranslateX() - arme.getTranslateX(), 2) + Math.pow(getTranslateY() - arme.getTranslateY(), 2));
        boolean collision = distance < 50; // Vous pouvez ajuster la distance selon vos besoins
        System.out.println("Collision status: " + collision);
        return collision;
    }


    // COEUR ET PV

    public void setVueCoeur(VueCoeur vueCoeur) {
        this.vueCoeur = vueCoeur;
        miseAjourCoeur();
    }

    public int getpVie() {
        return pv;
    }

    public void setpVie(int pVie) {
        this.pv = pVie;
        miseAjourCoeur();
    }

    public void miseAjourCoeur() {
        if (vueCoeur != null) {
            vueCoeur.afficherImageSelonVie(pv);
        }
    }


    @Override
    public int getPv() {
        return super.getPv();
    }

    private static final double TOLERANCE = 20;
    @Override
    public void attaquer(Acteur ennemi) {
            if (Math.abs(getTranslateX() - ennemi.getTranslateX()) < TOLERANCE &&
                    Math.abs(getTranslateY() - ennemi.getTranslateY()) < TOLERANCE) {
                ennemi.recevoirDegats();
            }
        }




    public void recevoirDegats() {
        pv -= 10; // Réduire les points de vie du joueur
        miseAjourCoeur(); // Mettre à jour la vue des cœurs
    }

}
