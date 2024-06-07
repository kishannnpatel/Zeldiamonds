package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur;

public class Ennemi extends Acteur {


    public Ennemi(int pv, int vitesse, int degats) {super(pv, vitesse, degats);
    }

    @Override
    public void attaquer(Acteur joueur) {
        if (getTranslateX()==joueur.getTranslateX() && getTranslateY()==joueur.getTranslateY()){
            recevoirDegats(joueur);
        }

    }

    @Override
    public void recevoirDegats(Acteur joueur) {
        getPv() = getPv()-joueur.degats;
    }


}
