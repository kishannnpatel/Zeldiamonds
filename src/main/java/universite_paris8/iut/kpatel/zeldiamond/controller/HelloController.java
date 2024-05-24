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
import universite_paris8.iut.kpatel.zeldiamond.modele.Joueur;
import universite_paris8.iut.kpatel.zeldiamond.modele.Map;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Pane PaneMap;

    @FXML
    private TilePane TPMap;

    @FXML
    private Map map;

    @FXML
    private Joueur joueur;

    private Joueur enemie;

    private Timeline gameLoop;

    private int temps;

    private int vitesse = 10;

    /*---------------------initialise appelle de methode ,etc...-------------------------------*/

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        this.map = new Map();
        this.joueur = new Joueur(100);
        this.enemie = new Joueur(10);
        spriteMap();
        spriteJoueur();
        spriteAnimation();
        Animation();
        gameLoop.play();
    }

    public void spriteMap() {
        for (int i = 0; i < this.map.getTableau().length; i++) {
            for (int j = 0; j < this.map.getTableau()[i].length; j++) {
                Rectangle r = new Rectangle(35, 35);

                if (map.getTableau()[i][j] == 1) {
                    r.setFill(Color.BURLYWOOD); //si dans map couleur = 1, alors color Black.
                    r.setId("mur");
                } else if (map.getTableau()[i][j] == 2) {
                    r.setFill(Color.DARKGREY); //si dans map couleur = 2, alors color LightBlue.
                    r.setId("mur");
                } else {
                    r.setFill(Color.DARKRED); //si dans map numero != de 1 et 2, alors color BlueViolet.
                }
                this.TPMap.getChildren().add(r);// Ajout  rectangle au conteneur TPMap pour l'afficher.
            }
        }
    }
    // Partie pour le gameLoop

    public void spriteJoueur() {

        //size du joueur 25 sur 25
        Rectangle rec = new Rectangle(20, 20);
        // color du joueur
        rec.setFill(Color.STEELBLUE);
        // Attribut un id unique au rectangle qui est basé sur l'ID du joueur.
        rec.setId(String.valueOf(joueur.getId()));
        // Ajout rectangle qui représente le joueur dans conteneur PaneMap.
        this.PaneMap.getChildren().add(rec);
          // Le joueur peut ce déplacer grace au touche { zqsd } du clavier.
        // Ajout d'un filtre d'événement pour écouter les touches pressées et agir en conséquence.

        // translation X du rectangle avec la propriété X du joueur.
        rec.translateXProperty().bind(joueur.Xproperty());
        // translation Y du rectangle avec la propriété Y du joueur.
        rec.translateYProperty().bind(joueur.Yproperty());
    }

    /*----------------------SpriteAnimation------------------------------*/

    private void spriteAnimation() {

        //cree un nouv rectangle avec sa taille
        Rectangle rec = new Rectangle(20, 20); //size de l'enemie  20 sur 20
        rec.setFill(Color.GREEN); // color de l'enemie

        this.PaneMap.getChildren().add(rec); // Ajout du rectangle au panneau sur la carte
        // Lier les propriétés X et Y du rectangle aux propriétés X et Y de l'ennemi
        // permet au  rectangle de se déplace avec l'ennemi
        rec.translateXProperty().bind(enemie.Xproperty());
        rec.translateYProperty().bind(enemie.Yproperty());

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
                        enemie.setX(enemie.getX() + 5);// Déplace ennemi de 5 pixels vers la droite
                        enemie.setY(enemie.getY() + 5);// Déplace ennemi de 5 pixels vers le bas
                    }

                    temps++;
                })
        );
        // ajoute le key frame dans le gameLoop timeline
        gameLoop.getKeyFrames().add(keyFrame);
    }

    public boolean colisionsMap(int x, int y) {
        double joueurX = x;
        double joueurY = y;
        double joueurWidth = 20; // Largeur du joueur
        double joueurHeight = 20; // Hauteur du joueur

        for (int i = 0; i < this.map.getTableau().length; i++) {
            for (int j = 0; j < this.map.getTableau()[i].length; j++) {
                if (map.getTableau()[i][j] != 0) { // Un obstacle
                    double obstacleX = j * 35; // Position X de l'obstacle
                    double obstacleY = i * 35; // Position Y de l'obstacle
                    double obstacleWidth = 35; // Largeur de l'obstacle
                    double obstacleHeight = 35; // Hauteur de l'obstacle

                    if (joueurX < obstacleX + obstacleWidth &&
                            joueurX + joueurWidth > obstacleX &&
                            joueurY < obstacleY + obstacleHeight &&
                            joueurY + joueurHeight > obstacleY) {
                        return false;
                        // Collision détectée, gérer ici
                    }

                }
            }
        } return true;
    }

   @FXML
    private void bouger(KeyEvent event){
        if (event.getCode() == KeyCode.Q) {
            int t = joueur.getX() - this.vitesse;
            if (joueur.dansMap(t, joueur.getY())) {
                if(colisionsMap(t, joueur.getY())==false) return;
                joueur.setX(t);
            }
        }
        if (event.getCode() == KeyCode.D){
            int t = joueur.getX() +this.vitesse;
            if(joueur.dansMap(t, joueur.getY())){
                if(colisionsMap(t, joueur.getY())==false)return;
                joueur.setX(t);
            }
        }
        if (event.getCode() == KeyCode.S){
            int t = joueur.getY() +this.vitesse;
            if(joueur.dansMap(joueur.getX(), t)){
                if(colisionsMap(joueur.getX(), t)==false)return;
                joueur.setY(t);
            }
        }
        if (event.getCode() == KeyCode.Z){
            int t = joueur.getY() -this.vitesse;
            if(joueur.dansMap(joueur.getX(), t)){
                if(colisionsMap(joueur.getX(), t)==false)return;
                joueur.setY(t);
            }
        }
    }




}

























