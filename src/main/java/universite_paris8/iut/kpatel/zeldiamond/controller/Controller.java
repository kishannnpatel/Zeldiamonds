package universite_paris8.iut.kpatel.zeldiamond.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi.Ennemi;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Joueur;
import universite_paris8.iut.kpatel.zeldiamond.modele.Map;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueCoeur;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueEnnemi;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueJoueur;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueMap;

import java.net.URL;
import java.util.List;
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
    @FXML
    private HBox Coeur; // Supposons que hboxCoeur est l'élément dans votre fichier FXML où vous souhaitez afficher les images de cœur.
    private List<Ennemi> listeDesEnnemis;
    private VueCoeur vueCoeur;

    /*---------------------initialise appelle de methode ,etc...-------------------------------*/

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        this.map = new Map();
        VueMap vmap = new VueMap(map.getTableau(), tilePaneMap);
        vmap.spriteMap();
        this.joueur = new Joueur(100, 10 , 30 , 40);
        this.ennemi = new Ennemi(40 ,9 , 10 , 20);
        spriteJoueur();
        spriteEnnemi();
        Animation();
        vueCoeur = new VueCoeur(Coeur);
        joueur.setVueCoeur(vueCoeur); // Ensure the joueur object has the heart sprite reference
        gameLoop.play();
    }

    public void spriteJoueur() {
        paneMap.addEventFilter(KeyEvent.KEY_PRESSED, this::bougerJoueur);
        VueJoueur vueJoueur = new VueJoueur(joueur.getId(), paneMap);
        vueJoueur.creeVue();
        Pane pane = vueJoueur.getRec();
        pane.translateXProperty().bind(joueur.translateXProperty());
        pane.translateYProperty().bind(joueur.translateYProperty());
    }

    public void spriteEnnemi() {
        VueEnnemi vueennemi = new VueEnnemi(ennemi.getId(), paneMap);
        vueennemi.creeVue2();
        Pane pane = vueennemi.getRec();
        pane.translateXProperty().bind(ennemi.translateXProperty());
        pane.translateYProperty().bind(ennemi.translateYProperty());
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
                        System.out.println("un tour");
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
        }
    }

    @FXML
    public void bougerEnnemi() {

        Random random = new Random();
        int direction = random.nextInt(4) + 1; // Génère un nombre aléatoire entre 1 et 4

            switch (direction) {
                case 1:
                    ennemi.depGauche();
                    break;
                case 2:
                    ennemi.depDroite();
                    break;
                case 3:
                    ennemi.depHaut();
                    break;
                case 4:
                    ennemi.depBas();
                    break;

            }
        }
    }


