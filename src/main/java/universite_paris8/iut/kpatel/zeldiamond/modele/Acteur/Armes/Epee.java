package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes; // Déclaration du package de la classe

import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur; // Importation de la classe Acteur

public class Epee extends Armes { // Déclaration de la classe Epee qui hérite de la classe abstraite Armes

    private static final double TOLERANCE = 20; // Constante pour la tolérance de l'attaque

    public Epee(int degats) { // Constructeur de la classe Epee avec un paramètre pour les dégâts
        super(degats); // Appel du constructeur de la classe parent Armes
    }

    @Override
    public void attaquer(Acteur ennemi) { // Implémentation de la méthode abstraite attaquer() de la classe Armes
        if (Math.abs(getTranslateX() - ennemi.getTranslateX()) < TOLERANCE &&
                Math.abs(getTranslateY() - ennemi.getTranslateY()) < TOLERANCE) { // Vérification de la proximité de l'ennemi
            ennemi.recevoirDegats(); // Appel de la méthode recevoirDegats() sur l'ennemi
        }
    }

    public void setPosition(int x, int y) { // Méthode pour définir la position de l'épée
        setTranslateX(x); // Appel de la méthode héritée pour définir la translation en X
        setTranslateY(y); // Appel de la méthode héritée pour définir la translation en Y
    }
}
