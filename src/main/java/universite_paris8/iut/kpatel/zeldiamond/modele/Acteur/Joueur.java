package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Joueur  extends Acteur {

    public Joueur(int pv , int vitesse) {
        super(pv , vitesse);
    }

    public void depGauche(){
        int t = getTranslateX() - getVitesse();
        if (dansMap(t, getTranslateY())) {
            if (!getMap().colisionsMap(t, getTranslateY())) return;
            setTranslateX(t);
        }
    }

    public void depDroite(){
        int t = getTranslateX() + getVitesse();
        if (dansMap(t, getTranslateY())) {
            if (!getMap().colisionsMap(t,getTranslateY())) return;
            setTranslateX(t);
        }
    }

    public void depBas(){
        int t = getTranslateY() + getVitesse();
        if (dansMap(getTranslateX(), t)) {
            if (!getMap().colisionsMap(getTranslateX(), t)) return;
            setTranslateY(t);
        }
    }

    public void depHaut(){
        int t = getTranslateY() - getVitesse();
        if (dansMap(getTranslateX(), t)) {
            if (!getMap().colisionsMap(getTranslateX(), t)) return;
            setTranslateY(t);
        }
    }



}
