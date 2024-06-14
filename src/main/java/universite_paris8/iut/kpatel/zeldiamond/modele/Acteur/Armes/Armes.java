package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes; // Déclaration du package de la classe

import javafx.beans.property.DoubleProperty; // Importation de la classe DoubleProperty pour les propriétés double (non utilisée ici)
import javafx.beans.property.IntegerProperty; // Importation de la classe IntegerProperty pour les propriétés int
import javafx.beans.property.SimpleDoubleProperty; // Importation de la classe SimpleDoubleProperty pour les propriétés double simples (non utilisée ici)
import javafx.beans.property.SimpleIntegerProperty; // Importation de la classe SimpleIntegerProperty pour les propriétés int simples
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur; // Importation de la classe Acteur

public abstract class Armes { // Déclaration de la classe abstraite Armes

    private int degats; // Variable privée pour les dégâts de l'arme
    private IntegerProperty translateX; // Propriété pour la translation en X
    private IntegerProperty translateY; // Propriété pour la translation en Y

    public Armes(int degats) { // Constructeur de la classe Armes avec un paramètre pour les dégâts
        this.translateX = new SimpleIntegerProperty(0); // Initialisation de la propriété translateX à 0
        this.translateY = new SimpleIntegerProperty(0); // Initialisation de la propriété translateY à 0
        this.degats = degats; // Initialisation des dégâts de l'arme
    }

    public int getTranslateX() { // Méthode pour obtenir la valeur de translateX
        return this.translateX.get(); // Retourne la valeur de la propriété translateX
    }

    public IntegerProperty translateXProperty() { // Méthode pour obtenir la propriété translateX
        return this.translateX; // Retourne la propriété translateX
    }

    public void setTranslateX(int x) { // Méthode pour définir la valeur de translateX
        this.translateX.set(x); // Définit la valeur de la propriété translateX
    }

    public int getTranslateY() { // Méthode pour obtenir la valeur de translateY
        return this.translateY.get(); // Retourne la valeur de la propriété translateY
    }

    public IntegerProperty translateYProperty() { // Méthode pour obtenir la propriété translateY
        return this.translateY; // Retourne la propriété translateY
    }

    public void setTranslateY(int y) { // Méthode pour définir la valeur de translateY
        this.translateY.set(y); // Définit la valeur de la propriété translateY
    }

    public int getDegats() { // Méthode pour obtenir les dégâts de l'arme
        return degats; // Retourne les dégâts de l'arme
    }

    public abstract void attaquer(Acteur ennemi); // Méthode abstraite pour attaquer un ennemi, à implémenter dans les sous-classes
}
