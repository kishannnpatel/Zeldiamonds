package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;

public class Armes  extends Acteur {

    private int degats;
    private DoubleProperty x;
    private DoubleProperty y;

    public Armes(int degats, int x, int  y) {
        super( x , y ,  degats);

    }

}
