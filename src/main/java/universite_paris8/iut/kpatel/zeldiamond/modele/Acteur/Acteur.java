package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur; // Déclaration du package de la classe

import javafx.beans.property.IntegerProperty; // Importation de la classe IntegerProperty de JavaFX
import javafx.beans.property.SimpleIntegerProperty; // Importation de la classe SimpleIntegerProperty de JavaFX
import universite_paris8.iut.kpatel.zeldiamond.modele.Map; // Importation de la classe Map

public abstract class Acteur { // Déclaration de la classe abstraite Acteur

    protected int pv; // Points de vie de l'acteur, accessible aux classes filles et au même package
    private int vitesse = 10; // Vitesse de déplacement par défaut
    protected IntegerProperty translateX; // Propriété pour la position en X de l'acteur
    protected IntegerProperty translateY; // Propriété pour la position en Y de l'acteur
    protected int id; // Identifiant de l'acteur
    private Map map; // Instance de la classe Map pour la gestion de la carte
    protected int degats; // Dégâts infligés par l'acteur

    public Acteur(int x, int y, int pv, int vitesse, int degats) { // Constructeur de la classe Acteur avec plusieurs paramètres
        this.pv = pv; // Initialisation des points de vie avec l'argument du constructeur
        this.translateX = new SimpleIntegerProperty(x); // Initialisation de translateX avec la position X donnée
        this.translateY = new SimpleIntegerProperty(y); // Initialisation de translateY avec la position Y donnée
        this.id = 0; // Initialisation de l'id à 0 (à adapter selon la logique de votre jeu)
        this.map = new Map(); // Création d'une nouvelle instance de Map (à adapter selon la logique de votre jeu)
        this.vitesse = vitesse; // Initialisation de la vitesse avec l'argument du constructeur
        this.degats = degats; // Initialisation des dégâts avec l'argument du constructeur
    }

    // Méthodes pour gérer les points de vie (pv)
    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPv() {
        return pv;
    }

    // Méthode pour obtenir la vitesse
    public int getVitesse() {
        return vitesse;
    }

    // Méthodes pour obtenir et gérer la position en X
    public int getTranslateX() {
        return this.translateX.get();
    }

    public IntegerProperty translateXProperty() {
        return this.translateX;
    }

    public void setTranslateX(int x) {
        this.translateX.set(x);
    }

    // Méthodes pour obtenir et gérer la position en Y
    public int getTranslateY() {
        return this.translateY.get();
    }

    public IntegerProperty translateYProperty() {
        return this.translateY;
    }

    public void setTranslateY(int y) {
        this.translateY.set(y);
    }

    // Méthode pour obtenir l'identifiant
    public int getId() {
        return id;
    }

    // Méthodes pour obtenir et gérer la carte
    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    // Méthode pour vérifier si l'acteur est dans la carte
    public boolean dansMap(int x, int y) {
        return (0 <= x && x + 20 <= 1045 && 0 <= y && y + 20 <= 835); // Exemple de conditions à adapter selon la taille de votre carte
    }

    // Méthodes abstraites pour attaquer, recevoir des dégâts et mourir (implémentées dans les classes filles)
    public abstract void attaquer(Acteur ennemi);

    public abstract void recevoirDegats();

    protected abstract void mourir();
}
