package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;

public class Epee extends Armes{

    public Epee(int x, int y, int degats ) {
        super(x, y, degats);

    }

    public void setPosition(int x , int y){
      setTranslateX(x);
      setTranslateY(y);
    }
}
