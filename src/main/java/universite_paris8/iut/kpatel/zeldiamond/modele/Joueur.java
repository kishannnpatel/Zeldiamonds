package universite_paris8.iut.kpatel.zeldiamond.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Joueur {
    private int pv;
    private IntegerProperty translateX;
    private IntegerProperty translateY;
    private int id;

    public Joueur(int pv) {
        this.pv = pv;
        this.translateX = new SimpleIntegerProperty(0);// Initialise la propriété x à 375
        this.translateY = new SimpleIntegerProperty(0);// Initialise la propriété y à 375
        this.id = 0;
    }
    /* --------------------X---------------*/
    public int getTranslateX(){
        return this.translateX.getValue();
    }

    public IntegerProperty translateXproperty(){
        return this.translateX;
    }

    public void setTranslqteX(int x){
        this.translateX.setValue(x);
    }

    /* --------------------Y---------------*/
    public int getTranslateY(){
        return this.translateY.getValue();
    }

    public IntegerProperty translateYproperty(){
        return this.translateY;
    }

    public void setTranslateY(int y){
        this.translateY.setValue(y);
    }

    /* -----------------ID---------------*/

    public int getId() {
        return id;
    }

    // Vérifie que x et y sont dans les limites [0, 700]
    public static boolean dansMap(int x, int y){
        return (0<= x && x+20 <= 700 && 0<= y && y+20 <= 700);
    }
}
