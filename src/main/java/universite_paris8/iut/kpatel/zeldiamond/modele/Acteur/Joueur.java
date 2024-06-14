package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur; // Déclaration du package de la classe

import javafx.scene.layout.Pane; // Importation de la classe Pane de JavaFX
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes.Armes; // Importation de la classe Armes du package Armes
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes.Epee; // Importation de la classe Epee du package Armes
import universite_paris8.iut.kpatel.zeldiamond.vue.VueArmes; // Importation de la classe VueArmes
import universite_paris8.iut.kpatel.zeldiamond.vue.VueCoeur; // Importation de la classe VueCoeur
import universite_paris8.iut.kpatel.zeldiamond.vue.VueJoueur; // Importation de la classe VueJoueur

public class Joueur extends Acteur { // Déclaration de la classe Joueur qui hérite de Acteur

    private Armes armes; // Arme actuellement utilisée par le joueur
    private VueCoeur vueCoeur; // Vue des cœurs du joueur
    private boolean ramasseEpee; // Indicateur pour savoir si le joueur a ramassé une épée
    private VueArmes vueArmes; // Vue de l'arme sur la carte
    private static final double TOLERANCE = 30; // Tolérance pour la détection de collision
    private VueJoueur vueJoueur; // Vue du joueur sur la carte
    private Pane paneMap; // Pane sur lequel le joueur est affiché

    public Joueur(int x, int y, int pv, int vitesse, int degats) { // Constructeur de la classe Joueur avec plusieurs paramètres
        super(x, y, pv, vitesse, degats); // Appel du constructeur de la classe Acteur avec les paramètres spécifiés
    }

    public void ramasserArme(Epee epee, VueArmes vueArmes) { // Méthode pour ramasser une épée
        this.armes = epee; // Assignation de l'épée à l'attribut armes du joueur
        this.ramasseEpee = true; // Le joueur a ramassé une épée
        epee.translateXProperty().bind(this.translateXProperty()); // Liaison de la position X de l'épée à celle du joueur
        epee.translateYProperty().bind(this.translateYProperty().subtract(10)); // Liaison de la position Y de l'épée à celle du joueur moins un décalage
        vueArmes.getImageView().setVisible(false); // Cacher l'image de l'arme sur la carte
        System.out.println("Épée ramassée"); // Affichage dans la console
    }

    public void lacherArme(VueArmes vueArmes) { // Méthode pour lâcher une arme (spécifiquement une épée)
        if (ramasseEpee && armes instanceof Epee) { // Vérifie si le joueur a ramassé une épée et que l'arme actuelle est une instance de Epee
            Epee epee = (Epee) armes; // Conversion de l'arme en type Epee
            epee.translateXProperty().unbind(); // Détacher la liaison de la position X de l'épée
            epee.translateYProperty().unbind(); // Détacher la liaison de la position Y de l'épée
            epee.setTranslateX(this.getTranslateX()); // Définir la position X de l'épée à celle du joueur
            epee.setTranslateY(this.getTranslateY() + 10); // Définir la position Y de l'épée légèrement en dessous du joueur
            vueArmes.getImageView().setVisible(true); // Rendre visible l'image de l'arme sur la carte
            this.armes = null; // L'arme du joueur est maintenant null (il ne tient plus d'arme)
            this.ramasseEpee = false; // Le joueur n'a plus d'épée ramassée
            System.out.println("Épée lâchée"); // Affichage dans la console
        }
    }

    // Méthode pour détecter une collision entre le joueur et une arme
    public boolean isCollision(Armes arme) {
        double distance = Math.sqrt(Math.pow(getTranslateX() - arme.getTranslateX(), 2) + Math.pow(getTranslateY() - arme.getTranslateY(), 2));
        boolean collision = distance < 50; // Vérifie si la distance entre le joueur et l'arme est inférieure à 50 (à ajuster selon vos besoins)
        System.out.println("Collision status: " + collision); // Affichage du statut de la collision dans la console
        return collision; // Retourne true si collision, sinon false
    }

    public void setVueJoueur(VueJoueur vueJoueur) { // Méthode pour définir la vue du joueur
        this.vueJoueur = vueJoueur; // Assignation de la vue du joueur
    }

    // Méthode pour définir la vue des cœurs du joueur
    public void setVueCoeur(VueCoeur vueCoeur) {
        this.vueCoeur = vueCoeur; // Assignation de la vue des cœurs du joueur
        miseAjourCoeur(); // Met à jour l'affichage des cœurs
    }

    public int getpVie() { // Méthode pour obtenir les points de vie du joueur
        return pv; // Retourne les points de vie actuels du joueur
    }

    public void setpVie(int pVie) { // Méthode pour définir les points de vie du joueur
        this.pv = pVie; // Assignation des points de vie
        miseAjourCoeur(); // Met à jour l'affichage des cœurs
    }

    public void miseAjourCoeur() { // Méthode pour mettre à jour l'affichage des cœurs
        if (vueCoeur != null) { // Vérifie si la vue des cœurs est définie
            vueCoeur.afficherImageSelonVie(pv); // Appelle la méthode pour afficher l'image correspondant aux points de vie
        }
    }

    @Override
    public int getPv() { // Redéfinition de la méthode getPv() de la classe Acteur
        return super.getPv(); // Retourne les points de vie actuels du joueur (appel à la méthode de la classe parent Acteur)
    }

    @Override
    public void attaquer(Acteur ennemi) { // Redéfinition de la méthode attaquer() de la classe Acteur
        if (Math.abs(getTranslateX() - ennemi.getTranslateX()) < TOLERANCE &&
                Math.abs(getTranslateY() - ennemi.getTranslateY()) < TOLERANCE) {
            ennemi.recevoirDegats(); // Appelle la méthode recevoirDegats() de l'ennemi si le joueur est assez proche
        }
    }

    @Override
    public void recevoirDegats() { // Redéfinition de la méthode recevoirDegats() de la classe Acteur
        pv -= 5; // Réduit les points de vie du joueur
        miseAjourCoeur(); // Met à jour l'affichage des cœurs
        if (pv <= 0) { // Vérifie si les points de vie sont inférieurs ou égaux à zéro
            mourir(); // Gestion de la mort du joueur
        }
    }

    public void mourir() { // Méthode pour gérer la mort du joueur
        if (vueCoeur != null) { // Vérifie si la vue des cœurs est définie
            vueCoeur.afficherImageSelonVie(0); // Affiche zéro cœur
        }
        if (vueJoueur != null) { // Vérifie si la vue du joueur est définie
            vueJoueur.hideImage(); // Cache l'image du joueur
        }
        System.out.println("Joueur est mort"); // Affichage dans la console
    }
}
