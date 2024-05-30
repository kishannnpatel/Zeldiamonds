package universite_paris8.iut.kpatel.zeldiamond.modele;

public class Joueur  extends Acteur{

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



}
