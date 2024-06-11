package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;

public class Epee {
    private DoubleProperty x;
    private DoubleProperty y;
    private final int taille = 10;
    private Rectangle vue;

    public Epee(double x, double y) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.vue = new Rectangle(taille, taille);
        this.vue.translateXProperty().bind(this.x);
        this.vue.translateYProperty().bind(this.y);
    }

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public Rectangle getVue() {
        return vue;
    }
}
