package universite_paris8.iut.kpatel.zeldiamond.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes.Epee;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi.Ennemi;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi.EnnemiBoss;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Joueur;
import universite_paris8.iut.kpatel.zeldiamond.modele.Map;
import universite_paris8.iut.kpatel.zeldiamond.vue.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Pane paneMap;
    @FXML
    private TilePane tilePaneMap;
    private Map map;
    private Joueur joueur;
    private Timeline gameLoop;
    private int temps;
    private Ennemi ennemi;
    private EnnemiBoss ennemiBoss;
    @FXML
    private HBox Coeur; // Supposons que hboxCoeur est l'élément dans votre fichier FXML où vous souhaitez afficher les images de cœur.
    private VueCoeur vueCoeur;
    private Epee epee;
    private VueArmes vueArmes;
    private  ArrayList<Acteur> listEnnemis;


    /*---------------------initialise appelle de methode ,etc...-------------------------------*/

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        this.listEnnemis = new ArrayList<>();
        this.map = new Map();
        VueMap vmap = new VueMap(map.getTableau(), tilePaneMap);
        vmap.spriteMap();
        spriteJoueur();
        spriteEnnemi();
        spriteEnnemiBoss();
        Animation();
        vueCoeur = new VueCoeur(Coeur);
        joueur.setVueCoeur(vueCoeur);
        gameLoop.play();
        spriteArme();
    }

    public void spriteJoueur() {
        this.joueur = new Joueur(500, 500, 100, 15, 80); // Pass paneMap
        paneMap.addEventFilter(KeyEvent.KEY_PRESSED, this::bougerJoueur);
        VueJoueur vueJoueur = new VueJoueur(joueur.getId(), paneMap);
        vueJoueur.creeVue();
        joueur.setVueJoueur(vueJoueur); // Set the reference
        Pane pane = vueJoueur.getRec();
        pane.translateXProperty().bind(joueur.translateXProperty());
        pane.translateYProperty().bind(joueur.translateYProperty());
    }

    public void spriteEnnemi() {
        this.ennemi = new Ennemi(100, 100, 20, 8, 5);
        VueEnnemi vueEnnemi = new VueEnnemi(ennemi.getId(), paneMap);
        vueEnnemi.creeVueEnnemi();
        ennemi.setVueEnnemi(vueEnnemi); // Set the reference
        Pane pane = vueEnnemi.getRec();
        pane.translateXProperty().bind(ennemi.translateXProperty());
        pane.translateYProperty().bind(ennemi.translateYProperty());
        listEnnemis.add(ennemi);
    }

    public void spriteEnnemiBoss() {
        this.ennemiBoss = new EnnemiBoss(700, 700, 40, 8, 6);
        VueEnnemiBoss vueEnnemiBoss = new VueEnnemiBoss(ennemiBoss.getId(), paneMap);
        vueEnnemiBoss.creeVueEnnemiBoss();
        ennemiBoss.setVueEnnemiBoss(vueEnnemiBoss); // Set the reference
        Pane pane = vueEnnemiBoss.getRec();
        pane.translateXProperty().bind(ennemiBoss.translateXProperty());
        pane.translateYProperty().bind(ennemiBoss.translateYProperty());
        listEnnemis.add(ennemiBoss);
    }

    private void spriteArme() {
        this.epee = new Epee(100);
        vueArmes = new VueArmes(paneMap, epee);
        vueArmes.armes();
        epee.setPosition(400, 200);
    }

    /*----------------------Animation-------------------------------*/
    //gameLoop
    private void Animation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);// L'animation se répétera indéfiniment
        System.out.println("début loop");
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.030),// Définir la durée de l'image
                ev -> {
                    if (temps == 10000) {
                        System.out.println("fin   ");
                        gameLoop.stop();// Arrêter l'animation
                    } else if (temps % 5 == 0) {
                        ennemi.attaquer(joueur);
                        joueur.attaquer(ennemi);
                        ennemiBoss.attaquer(joueur);
                        epee.attaquer(ennemi);
                        System.out.println(ennemi.getPv());
                        System.out.println(ennemiBoss.getPv());
                        bougerEnnemi();
                    }
                    temps++;
                }
        );
        // ajoute le key frame dans le gameLoop timeline
        gameLoop.getKeyFrames().add(keyFrame);
    }

    @FXML
    public void bougerJoueur(KeyEvent event) {

        if (event.getCode() == KeyCode.Q) {
            joueur.depGauche();
        }
        if (event.getCode() == KeyCode.D) {
            joueur.depDroite();
        }
        if (event.getCode() == KeyCode.S) {
            joueur.depBas();
        }
        if (event.getCode() == KeyCode.Z) {
            joueur.depHaut();
        }if (event.getCode() == KeyCode.E) {
            System.out.println("Touche E pressée");
            if (joueur.isCollision(epee)) {
                System.out.println("Collision détectée avec l'épée");
                joueur.ramasserArme(epee, new VueArmes(paneMap, epee));
            } else {
                System.out.println("Pas de collision avec l'épée");
            }
        } if (event.getCode() == KeyCode.R) {
           System.out.println("Touche R pressée");
           joueur.lacherArme(vueArmes);
        }  if (event.getCode() == KeyCode.A){
            joueur.attaquer(ennemi);
        }
    }

    public void bougerEnnemi() {

        Random random = new Random();
        int direction = random.nextInt(6) + 1; // Génère un nombre aléatoire entre 1 et 4

        for (int i = 0; i < listEnnemis.size(); i++) {
            switch (direction) {
                case 1:
                    listEnnemis.get(i).depGauche();
                    break;
                case 2:
                    listEnnemis.get(i).depDroite();
                    break;
                case 3:
                    listEnnemis.get(i).depHaut();
                    break;
                case 4:
                    listEnnemis.get(i).depBas();
                    break;
            }
        }


    }

}






