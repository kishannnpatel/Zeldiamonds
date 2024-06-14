package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi; // Déclaration du package de la classe

import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur; // Importation de la classe Acteur
import universite_paris8.iut.kpatel.zeldiamond.vue.VueEnnemi; // Importation de la classe VueEnnemi

public class Ennemi extends Acteur { // Déclaration de la classe Ennemi qui hérite de la classe Acteur

    private static final double TOLERANCE = 20; // Constante pour la tolérance de l'attaque
    private VueEnnemi vueEnnemi; // Instance de la classe VueEnnemi pour la vue de l'ennemi

    public Ennemi(int x, int y, int pv, int vitesse, int degats) {
        super(x, y, pv, vitesse, degats); // Appel du constructeur de la classe parent Acteur avec les paramètres donnés
    }

    @Override
    public void recevoirDegats() { // Méthode pour recevoir des dégâts
        pv -= 20; // Réduction des points de vie de l'ennemi
        if (pv <= 0) { // Si les points de vie sont inférieurs ou égaux à 0
            mourir(); // Appel de la méthode mourir()
        }
    }

    @Override
    public void attaquer(Acteur joueur) { // Méthode pour faire attaquer l'ennemi
        if (Math.abs(getTranslateX() - joueur.getTranslateX()) < TOLERANCE &&
                Math.abs(getTranslateY() - joueur.getTranslateY()) < TOLERANCE) { // Vérification de la proximité du joueur
            joueur.recevoirDegats(); // Le joueur reçoit des dégâts
        }
    }

    @Override
    protected void mourir() { // Méthode pour gérer la mort de l'ennemi (méthode protégée, accessible seulement aux classes dans le même package ou héritantes)
        if (vueEnnemi != null) { // Si une vue de l'ennemi est définie
            vueEnnemi.hideEnnemi(); // Masquer l'ennemi dans la vue
        }
        System.out.println("Ennemi est mort"); // Affichage d'un message indiquant que l'ennemi est mort
    }

    public void setVueEnnemi(VueEnnemi vueEnnemi) { // Méthode pour définir la vue de l'ennemi
        this.vueEnnemi = vueEnnemi; // Attribution de l'instance de la vue de l'ennemi
    }
}
