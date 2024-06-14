package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi;

import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;

public class EnnemiBoss extends Acteur {
    private static final double TOLERANCE = 20;

    public EnnemiBoss(int x , int y , int pv, int vitesse, int degats) {
        super(x , y ,pv, vitesse, degats);
    }

    public void attaquer(Acteur joueur) {
        if (Math.abs(getTranslateX() - joueur.getTranslateX()) < TOLERANCE &&
                Math.abs(getTranslateY() - joueur.getTranslateY()) < TOLERANCE) {
            joueur.recevoirDegats();
        }
    }

    @Override
    public void recevoirDegats() {
        pv -= 20;
    }
}
