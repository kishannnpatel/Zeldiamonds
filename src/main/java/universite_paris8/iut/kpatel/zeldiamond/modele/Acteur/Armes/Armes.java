package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;

public abstract class Armes {

    private int degats;
    private IntegerProperty translateX;
    private IntegerProperty translateY;

    public Armes(int degats) {
        this.translateX = new SimpleIntegerProperty(0);;
        this.translateY = new SimpleIntegerProperty(0);;
        this.degats= degats;
    }

    public int getTranslateX() {
        return this.translateX.get();
    }

    public IntegerProperty translateXProperty() {
        return this.translateX;
    }

    public void setTranslateX(int x) {
        this.translateX.set(x);
    }

    public int getTranslateY() {
        return this.translateY.get();
    }

    public IntegerProperty translateYProperty() {
        return this.translateY;
    }

    public void setTranslateY(int y) {
        this.translateY.set(y);
    }

    public int getDegats() {
        return degats;
    }

    public abstract void attaquer(Acteur ennemi);
}
