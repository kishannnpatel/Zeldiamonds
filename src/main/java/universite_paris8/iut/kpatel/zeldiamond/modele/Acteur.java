package universite_paris8.iut.kpatel.zeldiamond.modele;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {
    protected int pv;
    protected IntegerProperty translateX;
    protected IntegerProperty translateY;
    protected int id;

    public Acteur(int pv) {
        this.pv = pv;
        this.translateX = new SimpleIntegerProperty(0);
        this.translateY = new SimpleIntegerProperty(0);
        this.id = 0;
    }

    // ----------------les pV --------------

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPv() {
        return pv;
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

    public int getId() {
        return id;
    }

    public static boolean dansMap(int x, int y) {
        return (0 <= x && x + 20 <= 700 && 0 <= y && y + 20 <= 700);
    }
}
