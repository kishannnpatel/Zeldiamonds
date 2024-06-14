package universite_paris8.iut.kpatel.zeldiamond.controller; // Déclare le package de la classe

import javafx.animation.KeyFrame; // Importation de la classe KeyFrame pour les animations
import javafx.animation.Timeline; // Importation de la classe Timeline pour les animations
import javafx.fxml.FXML; // Importation de l'annotation FXML pour l'injection de dépendances
import javafx.fxml.Initializable; // Importation de l'interface Initializable pour l'initialisation du contrôleur
import javafx.scene.input.KeyCode; // Importation de la classe KeyCode pour la gestion des événements clavier
import javafx.scene.input.KeyEvent; // Importation de la classe KeyEvent pour les événements clavier
import javafx.scene.layout.*; // Importation des classes de mise en page
import javafx.util.Duration; // Importation de la classe Duration pour les durées d'animation
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur; // Importation de la classe Acteur
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes.Epee; // Importation de la classe Epee
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi.Ennemi; // Importation de la classe Ennemi
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi.EnnemiBoss; // Importation de la classe EnnemiBoss
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Joueur; // Importation de la classe Joueur
import universite_paris8.iut.kpatel.zeldiamond.modele.Map; // Importation de la classe Map
import universite_paris8.iut.kpatel.zeldiamond.vue.*; // Importation des classes de vue

import java.net.URL; // Importation de la classe URL pour les ressources
import java.util.ArrayList; // Importation de la classe ArrayList pour les listes dynamiques
import java.util.Random; // Importation de la classe Random pour les nombres aléatoires
import java.util.ResourceBundle; // Importation de la classe ResourceBundle pour les ressources localisées

public class Controller implements Initializable { // Déclaration de la classe Controller qui implémente Initializable

    @FXML
    private BorderPane borderPane; // Injection du BorderPane depuis le fichier FXML
    @FXML
    private Pane paneMap; // Injection du Pane depuis le fichier FXML
    @FXML
    private TilePane tilePaneMap; // Injection du TilePane depuis le fichier FXML
    private Map map; // Déclaration de la variable map de type Map
    private Joueur joueur; // Déclaration de la variable joueur de type Joueur
    private Timeline gameLoop; // Déclaration de la variable gameLoop de type Timeline
    private int temps; // Déclaration de la variable temps de type int
    private Ennemi ennemi; // Déclaration de la variable ennemi de type Ennemi
    private EnnemiBoss ennemiBoss; // Déclaration de la variable ennemiBoss de type EnnemiBoss
    @FXML
    private HBox Coeur; // Injection du HBox pour les coeurs depuis le fichier FXML
    private VueCoeur vueCoeur; // Déclaration de la variable vueCoeur de type VueCoeur
    private Epee epee; // Déclaration de la variable epee de type Epee
    private VueArmes vueArmes; // Déclaration de la variable vueArmes de type VueArmes
    private ArrayList<Acteur> listEnnemis; // Déclaration de la liste listEnnemis de type ArrayList<Acteur>

    @Override
    public void initialize(URL location, ResourceBundle resource) { // Implémentation de la méthode initialize
        this.listEnnemis = new ArrayList<>(); // Initialisation de la liste des ennemis
        this.map = new Map(); // Initialisation de la carte
        VueMap vmap = new VueMap(map.getTableau(), tilePaneMap); // Création de la vue de la carte
        vmap.spriteMap(); // Génération des sprites de la carte
        spriteJoueur(); // Génération du sprite du joueur
        spriteEnnemi(); // Génération du sprite de l'ennemi
        spriteEnnemiBoss(); // Génération du sprite du boss ennemi
        Animation(); // Initialisation de l'animation
        vueCoeur = new VueCoeur(Coeur); // Création de la vue des coeurs
        joueur.setVueCoeur(vueCoeur); // Liaison de la vue des coeurs avec le joueur
        gameLoop.play(); // Démarrage de la boucle de jeu
        spriteArme(); // Génération du sprite de l'arme
    }

    public void spriteJoueur() { // Méthode pour créer le sprite du joueur
        this.joueur = new Joueur(500, 500, 100, 15, 80); // Initialisation du joueur avec des paramètres
        paneMap.addEventFilter(KeyEvent.KEY_PRESSED, this::bougerJoueur); // Ajout d'un filtre d'événement pour le déplacement du joueur
        VueJoueur vueJoueur = new VueJoueur(joueur.getId(), paneMap); // Création de la vue du joueur
        vueJoueur.creeVue(); // Création de la vue du joueur
        joueur.setVueJoueur(vueJoueur); // Liaison de la vue du joueur avec le joueur
        Pane pane = vueJoueur.getRec(); // Récupération du panneau de la vue du joueur
        pane.translateXProperty().bind(joueur.translateXProperty()); // Liaison de la propriété de translation en X
        pane.translateYProperty().bind(joueur.translateYProperty()); // Liaison de la propriété de translation en Y
    }

    public void spriteEnnemi() { // Méthode pour créer le sprite de l'ennemi
        this.ennemi = new Ennemi(100, 100, 20, 8, 5); // Initialisation de l'ennemi avec des paramètres
        VueEnnemi vueEnnemi = new VueEnnemi(ennemi.getId(), paneMap); // Création de la vue de l'ennemi
        vueEnnemi.creeVueEnnemi(); // Création de la vue de l'ennemi
        ennemi.setVueEnnemi(vueEnnemi); // Liaison de la vue de l'ennemi avec l'ennemi
        Pane pane = vueEnnemi.getRec(); // Récupération du panneau de la vue de l'ennemi
        pane.translateXProperty().bind(ennemi.translateXProperty()); // Liaison de la propriété de translation en X
        pane.translateYProperty().bind(ennemi.translateYProperty()); // Liaison de la propriété de translation en Y
        listEnnemis.add(ennemi); // Ajout de l'ennemi à la liste des ennemis
    }

    public void spriteEnnemiBoss() { // Méthode pour créer le sprite du boss ennemi
        this.ennemiBoss = new EnnemiBoss(700, 700, 40, 8, 6); // Initialisation du boss ennemi avec des paramètres
        VueEnnemiBoss vueEnnemiBoss = new VueEnnemiBoss(ennemiBoss.getId(), paneMap); // Création de la vue du boss ennemi
        vueEnnemiBoss.creeVueEnnemiBoss(); // Création de la vue du boss ennemi
        ennemiBoss.setVueEnnemiBoss(vueEnnemiBoss); // Liaison de la vue du boss ennemi avec le boss ennemi
        Pane pane = vueEnnemiBoss.getRec(); // Récupération du panneau de la vue du boss ennemi
        pane.translateXProperty().bind(ennemiBoss.translateXProperty()); // Liaison de la propriété de translation en X
        pane.translateYProperty().bind(ennemiBoss.translateYProperty()); // Liaison de la propriété de translation en Y
        listEnnemis.add(ennemiBoss); // Ajout du boss ennemi à la liste des ennemis
    }

    private void spriteArme() { // Méthode pour créer le sprite de l'arme
        this.epee = new Epee(100); // Initialisation de l'épée avec des paramètres
        vueArmes = new VueArmes(paneMap, epee); // Création de la vue de l'épée
        vueArmes.armes(); // Génération des armes dans la vue
        epee.setPosition(400, 200); // Positionnement initial de l'épée
    }

    private void Animation() { // Méthode pour initialiser l'animation
        gameLoop = new Timeline(); // Initialisation de la Timeline pour l'animation
        temps = 0; // Initialisation du temps à 0
        gameLoop.setCycleCount(Timeline.INDEFINITE); // Définition de la répétition infinie de l'animation
        System.out.println("début loop"); // Impression d'un message de début de boucle
        KeyFrame keyFrame = new KeyFrame( // Création d'un KeyFrame pour l'animation
                Duration.seconds(0.030), // Définition de la durée de l'image
                ev -> { // Définition de l'action à effectuer à chaque frame
                    if (temps == 10000) { // Si le temps atteint 10000
                        System.out.println("fin   "); // Impression d'un message de fin
                        gameLoop.stop(); // Arrêt de l'animation
                    } else if (temps % 5 == 0) { // Si le temps est un multiple de 5
                        ennemi.attaquer(joueur); // L'ennemi attaque le joueur
                        ennemiBoss.attaquer(joueur); // Le boss ennemi attaque le joueur
                        epee.attaquer(ennemi); // L'épée attaque l'ennemi
                        System.out.println(ennemi.getPv()); // Impression des points de vie de l'ennemi
                        System.out.println(ennemiBoss.getPv()); // Impression des points de vie du boss ennemi
                        System.out.println(joueur.getPv()); // Impression des points de vie du joueur
                        bougerEnnemi(); // Déplacement des ennemis
                    }
                    temps++; // Incrémentation du temps
                }
        );
        gameLoop.getKeyFrames().add(keyFrame); // Ajout du KeyFrame à la Timeline
    }

    @FXML
    public void bougerJoueur(KeyEvent event) { // Méthode pour gérer le déplacement du joueur

        if (event.getCode() == KeyCode.Q) { // Si la touche Q est pressée
            joueur.depGauche(); // Déplacer le joueur à gauche
        }
        if (event.getCode() == KeyCode.D) { // Si la touche D est pressée
            joueur.depDroite(); // Déplacer le joueur à droite
        }
        if (event.getCode() == KeyCode.S) { // Si la touche S est pressée
            joueur.depBas(); // Déplacer le joueur vers le bas
        }
        if (event.getCode() == KeyCode.Z) { // Si la touche Z est pressée
            joueur.depHaut(); // Déplacer le joueur vers le haut
        }
        if (event.getCode() == KeyCode.E) { // Si la touche E est pressée
            System.out.println("Touche E pressée"); // Impression d'un message
            if (joueur.isCollision(epee)) { // Si le joueur est en collision avec l'épée
                System.out.println("Collision détectée avec l'épée"); // Impression d'un message
                joueur.ramasserArme(epee, new VueArmes(paneMap, epee)); // Le joueur ramasse l'épée
            } else {
                System.out.println("Pas de collision avec l'épée"); // Impression d'un message
            }
        }
        if (event.getCode() == KeyCode.R) { // Si la touche R est pressée
            System.out.println("Touche R pressée"); // Impression d'un message
            joueur.lacherArme(vueArmes); // Le joueur lâche l'arme
        }
        if (event.getCode() == KeyCode.A) { // Si la touche A est pressée
            joueur.attaquer(ennemiBoss); // Le joueur attaque le boss ennemi
            joueur.attaquer(ennemi); // Le joueur attaque l'ennemi
        }
    }

    public void bougerEnnemi() { // Méthode pour déplacer les ennemis

        Random random = new Random(); // Création d'un générateur de nombres aléatoires
        int direction = random.nextInt(6) + 1; // Génération d'un nombre aléatoire entre 1 et 6

        for (int i = 0; i < listEnnemis.size(); i++) { // Pour chaque ennemi dans la liste
            switch (direction) { // Selon la direction générée
                case 1:
                    listEnnemis.get(i).depGauche(); // Déplacer l'ennemi à gauche
                    break;
                case 2:
                    listEnnemis.get(i).depDroite(); // Déplacer l'ennemi à droite
                    break;
                case 3:
                    listEnnemis.get(i).depHaut(); // Déplacer l'ennemi vers le haut
                    break;
                case 4:
                    listEnnemis.get(i).depBas(); // Déplacer l'ennemi vers le bas
                    break;
            }
        }
    }
}
