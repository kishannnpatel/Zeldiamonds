package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes;


import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;

public class Epee extends Armes{
    private static final double TOLERANCE = 20;

    public Epee(int degats) {
        super(degats);
    }

    @Override
    public void attaquer(Acteur ennemi) {
        if (Math.abs(getTranslateX() - ennemi.getTranslateX()) < TOLERANCE &&
                Math.abs(getTranslateY() - ennemi.getTranslateY()) < TOLERANCE) {
            ennemi.recevoirDegats();
        }
    }

    public void setPosition(int x , int y){
      setTranslateX(x);
      setTranslateY(y);
    }
}
