package universite_paris8.iut.kpatel.zeldiamond.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Joueur {
    private int pv;
    private IntegerProperty x , y ;
    private int id;

    public Joueur(int pv) {
        this.pv = pv;
        this.x = new SimpleIntegerProperty(350);// Initialise la propriété x à 375
        this.y = new SimpleIntegerProperty(350);// Initialise la propriété y à 375
        this.id = 0;
    }
    /* --------------------X---------------*/
    public int getX(){
        return this.x.getValue();
    }

    public IntegerProperty Xproperty(){
        return this.x;
    }

    public void setX(int x){
        this.x.setValue(x);
    }

    /* --------------------Y---------------*/
    public int getY(){
        return this.y.getValue();
    }

    public IntegerProperty Yproperty(){
        return this.y;
    }

    public void setY(int y){
        this.y.setValue(y);
    }

    /* -----------------ID---------------*/

    public int getId() {
        return id;
    }

    // Vérifie que x et y sont dans les limites [0, 700]
    public boolean dansMap(int x, int y){
        return (0<= x && x <= 700 && 0<= y && y <= 700);
    }
}
