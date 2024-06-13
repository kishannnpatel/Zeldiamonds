package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes;


import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;

public class Epee extends Acteur {

    public Epee(int x, int y, int degats ) {
        super(x,y,degats);

    }

    @Override
    public void attaquer(Acteur acteur) {

    }

    @Override
    public void recevoirDegats() {

    }


    public void setPosition(int x , int y){
      setTranslateX(x);
      setTranslateY(y);
    }
}
