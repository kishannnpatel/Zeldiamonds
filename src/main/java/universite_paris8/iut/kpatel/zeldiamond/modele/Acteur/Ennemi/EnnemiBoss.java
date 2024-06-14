package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi; // Déclaration du package de la classe

import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur; // Importation de la classe Acteur
import universite_paris8.iut.kpatel.zeldiamond.vue.VueEnnemiBoss; // Importation de la classe VueEnnemiBoss

public class EnnemiBoss extends Acteur { // Déclaration de la classe EnnemiBoss qui hérite de la classe Acteur

    private static final double TOLERANCE = 20; // Constante pour la tolérance de l'attaque
    private VueEnnemiBoss vueEnnemiBoss; // Instance de la classe VueEnnemiBoss pour la vue de l'ennemi boss

    public EnnemiBoss(int x, int y, int pv, int vitesse, int degats) { // Constructeur de la classe EnnemiBoss avec les paramètres nécessaires
        super(x, y, pv, vitesse, degats); // Appel du constructeur de la classe parent Acteur avec les paramètres donnés
    }

    public void attaquer(Acteur joueur) { // Méthode pour faire attaquer l'ennemi boss
        if (Math.abs(getTranslateX() - joueur.getTranslateX()) < TOLERANCE &&
                Math.abs(getTranslateY() - joueur.getTranslateY()) < TOLERANCE) { // Vérification de la proximité du joueur
            joueur.recevoirDegats(); // Le joueur reçoit des dégâts
        }
    }

    @Override
    public void recevoirDegats() { // Méthode pour recevoir des dégâts
        pv -= 20; // Réduction des points de vie de l'ennemi boss
        if (pv <= 0) { // Si les points de vie sont inférieurs ou égaux à 0
            mourir(); // Appel de la méthode mourir()
        }
    }

    @Override
    protected void mourir() { // Méthode pour gérer la mort de l'ennemi boss (méthode protégée, accessible seulement aux classes dans le même package ou héritantes)
        if (vueEnnemiBoss != null) { // Si une vue de l'ennemi boss est définie
            vueEnnemiBoss.hideEnnemiBoss(); // Masquer l'ennemi boss dans la vue
        }
        System.out.println("EnnemiBoss est mort"); // Affichage d'un message indiquant que l'ennemi boss est mort
    }

    public void setVueEnnemiBoss(VueEnnemiBoss vueEnnemiBoss) { // Méthode pour définir la vue de l'ennemi boss
        this.vueEnnemiBoss = vueEnnemiBoss; // Attribution de l'instance de la vue de l'ennemi boss
    }
}
