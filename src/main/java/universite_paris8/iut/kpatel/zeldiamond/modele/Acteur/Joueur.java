package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur;

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
    private int pVie;
    private boolean ramasseEpee;

    private List<Ennemi>cible;

    public Joueur(int pv, int vitesse , int degats ) {
        super(pv , vitesse , degats);
        this.pVie = pv;
        this.cible = new ArrayList<>();

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
        return pVie;
    }

    public void setpVie(int pVie) {
        this.pVie = pVie;
        miseAjourCoeur();
    }

    public void miseAjourCoeur() {
        if (vueCoeur != null) {
            vueCoeur.afficherImageSelonVie(pVie);
        }
    }


    @Override
    public int getPv() {
        return super.getPv();
    }


}
