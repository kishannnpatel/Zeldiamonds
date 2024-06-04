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
import javafx.util.Duration;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Ennemi;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Joueur;
import universite_paris8.iut.kpatel.zeldiamond.modele.Map;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueEnnemi;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueJoueur;
import universite_paris8.iut.kpatel.zeldiamond.vue.VueMap;

import java.net.URL;
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





    /*---------------------initialise appelle de methode ,etc...-------------------------------*/

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        this.map = new Map();
        VueMap vmap= new VueMap(map.getTableau(), tilePaneMap);
        vmap.spriteMap();
        this.joueur = new Joueur(100 , 10);

        this.ennemi = new Ennemi(90 , 10);
        spriteJoueur();
        spriteEnnemi();

        Animation();
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

    public void spriteEnnemi(){
        VueEnnemi vueennemi = new VueEnnemi(ennemi.getId(), paneMap);
        vueennemi.creeVue2();
        Pane pane = vueennemi.getRec();
        pane.translateXProperty().bind(ennemi.translateXProperty());
        pane.translateYProperty().bind(ennemi.translateYProperty());
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
                        ennemi.setTranslateX(ennemi.getTranslateX() + 5);// Déplace ennemi de 5 pixels vers la droite
                        ennemi.setTranslateY(ennemi.getTranslateY() + 5);// Déplace ennemi de 5 pixels vers le bas
                    }
                    temps++;
                })
        );
        // ajoute le key frame dans le gameLoop timeline
        gameLoop.getKeyFrames().add(keyFrame);
    }

    @FXML public void bougerJoueur(KeyEvent event) {
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
    @FXML public void bougerEnnemi(){

    }
}