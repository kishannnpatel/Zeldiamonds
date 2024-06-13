package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi;

import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;

public class Ennemi extends Acteur {

 private int pv;
 private int degats;
    public Ennemi(int pv, int vitesse, int degats) {super(pv, vitesse, degats);
    }


    private static final double TOLERANCE = 20; // Par exemple, 0.1 peut être ajusté selon vos besoins




    @Override
    public void attaquer(Acteur joueur) {
        if (Math.abs(getTranslateX() - joueur.getTranslateX()) < TOLERANCE &&
                Math.abs(getTranslateY() - joueur.getTranslateY()) < TOLERANCE) {
            joueur.recevoirDegats();

        }
    }

    @Override
    public void recevoirDegats() {

    }


}