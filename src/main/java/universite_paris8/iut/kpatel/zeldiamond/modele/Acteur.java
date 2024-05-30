package universite_paris8.iut.kpatel.zeldiamond.modele;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {
    protected int pv; // Initialisation des points de vie avec l'argument du constructeur
    private int vitesse = 10;
    protected IntegerProperty translateX;
    protected IntegerProperty translateY;
    protected int id;
    private Map map;


    public Acteur(int pv , int vitesse ) {
        this.pv = pv; // Initialisation des points de vie avec l'argument du constructeur
        this.translateX = new SimpleIntegerProperty(0);// Initialisation de translateX à 0
        this.translateY = new SimpleIntegerProperty(0);// Initialisation de translateY à 0
        this.id = 0; // Initialisation de l'id à 0
        this.map = new Map();// Création d'une nouvelle instance de Map
        this.vitesse = vitesse; // Initialisation de la vitesse avec l'argument du constructeu
    }

    // ----------------les pV --------------

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPv() {
        return pv;
    }

    public int getVitesse() {
        return vitesse;
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

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public  boolean dansMap(int x, int y) {
        return (0 <= x && x + 20 <= 700 && 0 <= y && y + 20 <= 700);
    }

   /* public void depGauche(){
        int t = getTranslateX() - vitesse;
        if (Joueur.dansMap(t,getTranslateY())) {
            if (!map.colisionsMap(t, getTranslateY())) return;
            setTranslateX(t);
        }
    }

    public void depDroite(){
        int t = getTranslateX() + vitesse;
        if (Joueur.dansMap(t, getTranslateY())) {
            if (!map.colisionsMap(t, getTranslateY())) return;
            setTranslateX(t);
        }
    }

    public void depBas(){
        int t = getTranslateY() + vitesse;
        if (Joueur.dansMap(getTranslateX(), t)) {
            if (!map.colisionsMap(getTranslateX(), t)) return;
            setTranslateY(t);
        }
    }

    public void depHaut(){
        int t = getTranslateY() - vitesse;
        if (Joueur.dansMap(getTranslateX(), t)) {
            if (!map.colisionsMap(getTranslateX(), t)) return;
            setTranslateY(t);
        }
    }*/



}


