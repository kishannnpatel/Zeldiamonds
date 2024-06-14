package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi;

import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueEnnemiBoss;

public class EnnemiBoss extends Acteur {
    private static final double TOLERANCE = 20;
    private VueEnnemiBoss vueEnnemiBoss;

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
        if (pv <= 0) {
            mourir();
        }
    }

    @Override
    protected void mourir() {
        if (vueEnnemiBoss != null) {
            vueEnnemiBoss.hideEnnemi();
        }
        System.out.println("EnnemiBoss est mort");
    }

    public void setVueEnnemiBoss(VueEnnemiBoss vueEnnemiBoss) {
        this.vueEnnemiBoss = vueEnnemiBoss;
    }
}
