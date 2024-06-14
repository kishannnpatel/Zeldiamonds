package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Diamant {
    private DoubleProperty translateX;
    private DoubleProperty translateY;

    public Diamant(double x, double y) {
        this.translateX = new SimpleDoubleProperty(x);
        this.translateY = new SimpleDoubleProperty(y);
    }

    public double getTranslateX() {
        return translateX.get();
    }

    public void setTranslateX(double translateX) {
        this.translateX.set(translateX);
    }

    public DoubleProperty translateXProperty() {
        return translateX;
    }

    public double getTranslateY() {
        return translateY.get();
    }

    public void setTranslateY(double translateY) {
        this.translateY.set(translateY);
    }

    public DoubleProperty translateYProperty() {
        return translateY;
    }
}
