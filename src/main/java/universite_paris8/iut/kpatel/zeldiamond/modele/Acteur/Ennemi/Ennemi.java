package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi;

import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueEnnemi;

public class Ennemi extends Acteur {
    private static final double TOLERANCE = 20;
    private VueEnnemi vueEnnemi;

    public Ennemi( int x , int y , int pv, int vitesse, int degats) {super(x , y , pv, vitesse, degats);
    }

    @Override
    public void recevoirDegats() {
        pv -= 20;
        if (pv <= 0) {
            mourir();
        }
    }

    @Override
    public void attaquer(Acteur joueur) {
        if (Math.abs(getTranslateX() - joueur.getTranslateX()) < TOLERANCE &&
                Math.abs(getTranslateY() - joueur.getTranslateY()) < TOLERANCE) {
            joueur.recevoirDegats();
        }
    }
    @Override
    protected void mourir() {
        if (vueEnnemi != null) {
            vueEnnemi.hideEnnemi();
        }
        System.out.println("Ennemi est mort");
    }

    public void setVueEnnemi(VueEnnemi vueEnnemi) {
        this.vueEnnemi = vueEnnemi;
    }
}
