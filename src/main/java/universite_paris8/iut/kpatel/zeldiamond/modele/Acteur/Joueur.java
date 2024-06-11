package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur;

import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi.Ennemi;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueCoeur;

import java.util.ArrayList;
import java.util.List;

public class Joueur extends Acteur {

    private VueCoeur vueCoeur;
    private int pVie;

    private List<Ennemi>cible;

    public Joueur(int pv, int vitesse , int x , int y) {
        super(pv , vitesse , x , y);
        this.pVie = pv;
        this.cible = new ArrayList<>();

    }

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
