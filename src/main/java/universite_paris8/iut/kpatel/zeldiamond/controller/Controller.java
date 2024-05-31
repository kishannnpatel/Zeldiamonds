package universite_paris8.iut.kpatel.zeldiamond.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Joueur;
import universite_paris8.iut.kpatel.zeldiamond.modele.Map;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueJoueur;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueMap;

import universite_paris8.iut.kpatel.zeldiamond.vue.vueEnnemi;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Pane PaneMap;
    @FXML
    private TilePane TPMap;
    private Map map;
    private Joueur joueur;
    private Joueur gameloop;
    private Timeline gameLoop;
    private int temps;
    private Ennemi ennemi;





    /*---------------------initialise appelle de methode ,etc...-------------------------------*/

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        this.map = new Map();
        VueMap vmap= new VueMap(map.getTableau(), TPMap);
        vmap.spriteMap();
        this.joueur = new Joueur(100 , 10);
        this.gameloop = new Joueur(10  , 20);
        this.ennemi = new Ennemi(90 , 10);
        spriteJoueur();
        spriteAnimation();
        Animation();
        gameLoop.play();
    }


    public void spriteJoueur() {
        PaneMap.addEventFilter(KeyEvent.KEY_PRESSED, this::bouger);
        VueJoueur vueJoueur = new VueJoueur(joueur.getId(), PaneMap);
        vueJoueur.creeVue();

        Pane pane = vueJoueur.getRec();

        pane.translateXProperty().bind(joueur.translateXProperty());
        pane.translateYProperty().bind(joueur.translateYProperty());
    }

    public void spriteEnnemi(){
        vueEnnemi vueennemi = new vueEnnemi(ennemi.getId(), PaneMap);
        vueennemi.creeVue2();

        Pane pane = vueennemi.getRec();

        pane.translateXProperty().bind(ennemi.translateXProperty());
        pane.translateYProperty().bind(ennemi.translateYProperty());
    }



    /*----------------------SpriteAnimation------------------------------*/

    private void spriteAnimation() {
        // Crée un nouveau rectangle avec sa taille
        Rectangle rec = new Rectangle(20, 20); // Taille de l'ennemi 20x20
        rec.setFill(Color.GREEN); // Couleur de l'ennemi

        // Ajout du rectangle au panneau sur la carte
        this.PaneMap.getChildren().add(rec);

        // Lier les propriétés X et Y du rectangle aux propriétés X et Y de l'ennemi
        // permet au rectangle de se déplacer avec l'ennemi
        rec.translateXProperty().bind(gameloop.translateXProperty());
        rec.translateYProperty().bind(gameloop.translateYProperty());
    }

    /*----------------------Animation-------------------------------*/
    // gameLoop
    private void Animation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);// L'animation se répétera indéfiniment
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.017),// Définir la durée de l'image
                (ev -> {

                    if (temps == 10000) {
                        System.out.println("fin");
                        gameLoop.stop();// Arrêter l'animation
                    } else if (temps % 5 == 0) {
                        //System.out.println("un tour");
                        gameloop.setTranslateX(gameloop.getTranslateX() + 5);// Déplace ennemi de 5 pixels vers la droite
                        gameloop.setTranslateY(gameloop.getTranslateY() + 5);// Déplace ennemi de 5 pixels vers le bas
                    }
                    temps++;
                })
        );
        // ajoute le key frame dans le gameLoop timeline
        gameLoop.getKeyFrames().add(keyFrame);
    }

    @FXML public void bouger(KeyEvent event) {
        if (event.getCode() == KeyCode.Q) {
            joueur.depGauche();
        }
        if (event.getCode() == KeyCode.D){
            joueur.depDroite();
        }
        if (event.getCode() == KeyCode.S) {
            joueur.depBas();
        }
        if (event.getCode() == KeyCode.Z) {
            joueur.depHaut();
        }
    }
}