package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur;


public class Joueur  extends Acteur {


    public Joueur(int pv , int vitesse, int degats) {
        super(pv , vitesse, degats);
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

    @Override
    public void attaquer(Acteur ennemi) {
        if (getTranslateX()==ennemi.getTranslateX() && getTranslateY()==ennemi.getTranslateY()){

        }



    }

    @Override
    public void recevoirDegats(Acteur ennemi) {

    }


}
