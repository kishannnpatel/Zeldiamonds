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


    // Epee

    public boolean ramasseEpee() {
        return ramasseEpee;
    }

    public void ramasserArme(Epee epee, VueArmes vueArmes) {
        this.armes = epee;
        this.ramasseEpee = true;
        //vueArmes.hideArme();  // Hide the sword's ImageView
    }

    // DEPLACEMENT

    public void depGauche() {
        int t = getTranslateX() - getVitesse();
        if (dansMap(t, getTranslateY())) {
            if (!getMap().colisionsMap(t, getTranslateY())) return;
            setTranslateX(t);
        }
    }

    public void depDroite() {
        int t = getTranslateX() + getVitesse();
        if (dansMap(t, getTranslateY())) {
            if (!getMap().colisionsMap(t, getTranslateY())) return;
            setTranslateX(t);
        }
    }

    public void depBas() {
        int t = getTranslateY() + getVitesse();
        if (dansMap(getTranslateX(), t)) {
            if (!getMap().colisionsMap(getTranslateX(), t)) return;
            setTranslateY(t);
        }
    }

    public void depHaut() {
        int t = getTranslateY() - getVitesse();
        if (dansMap(getTranslateX(), t)) {
            if (!getMap().colisionsMap(getTranslateX(), t)) return;
            setTranslateY(t);
        }
    }


}
