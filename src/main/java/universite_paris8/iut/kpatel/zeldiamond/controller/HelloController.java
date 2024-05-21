package universite_paris8.iut.kpatel.zeldiamond.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/*import java.awt.event.KeyListener;*/

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.util.Duration;
import universite_paris8.iut.kpatel.zeldiamond.modele.Joueur;
import  universite_paris8.iut.kpatel.zeldiamond.modele.Map;

public class HelloController implements Initializable {

    @FXML private BorderPane borderPane;

    @FXML private Pane PaneMap;

    @FXML private TilePane TPMap;

    @FXML private Map map;

    @FXML private Joueur joueur;

    private Joueur enemie;

    private Timeline gameLoop;

    private int temps;

    /*---------------------initialise appelle de methode ,etc...-------------------------------*/

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        this.map= new Map();
        this.joueur=new Joueur(100);
        this.enemie= new Joueur(10);
        spriteMap();
        spriteJoueur();
        spriteAnimation();
        Animation();
        gameLoop.play();
    }

    public void spriteMap(){
        for (int i =0; i < this.map.getTableau().length;i++){
            for (int j =0; j < this.map.getTableau()[i].length;j++){
                Rectangle r = new Rectangle(35, 35);

                if (map.getTableau()[i][j] == 1) {
                    r.setFill(Color.BURLYWOOD); //si dans map couleur = 1, alors color Black.
                }else if (map.getTableau()[i][j] == 2){
                    r.setFill(Color.DARKGREY); //si dans map couleur = 2, alors color LightBlue.
                }else{
                    r.setFill(Color.DARKRED); //si dans map numero != de 1 et 2, alors color BlueViolet.
                }
                this.TPMap.getChildren().add(r);// Ajout  rectangle au conteneur TPMap pour l'afficher.
            }
        }
    }

    // Partie pour le gameLoop

    public void spriteJoueur(){

        //size du joueur 25 sur 25
        Rectangle rec = new Rectangle(20, 20);
        // color du joueur
        rec.setFill(Color.STEELBLUE);
        // Attribut un id unique au rectangle qui est basé sur l'ID du joueur.
        rec.setId(String.valueOf(joueur.getId()));
        // Ajout rectangle qui représente le joueur dans conteneur PaneMap.
        this.PaneMap.getChildren().add(rec);
        touche zqsd  = new touche(joueur);  // Le joueur peut ce déplacer grace au touche { zqsd } du clavier.
        // Ajout d'un filtre d'événement pour écouter les touches pressées et agir en conséquence.
        PaneMap.addEventFilter(KeyEvent.KEY_PRESSED, zqsd);
        // translation X du rectangle avec la propriété X du joueur.
        rec.translateXProperty().bind(joueur.Xproperty());
        // translation Y du rectangle avec la propriété Y du joueur.
        rec.translateYProperty().bind(joueur.Yproperty());
    }

/*----------------------SpriteAnimation------------------------------*/

    private void spriteAnimation(){

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
    private void Animation(){

        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);// L'animation se répétera indéfiniment
        KeyFrame keyFrame = new KeyFrame(

                Duration.seconds(0.017),// Définir la durée de l'image
                (ev ->{

                    if (temps==10000){
                        System.out.println("fin");
                        gameLoop.stop();// Arrêter l'animation
                    } else if (temps %5 == 0) {
                        //System.out.println("un tour");
                        enemie.setX(enemie.getX()+5);// Déplace ennemi de 5 pixels vers la droite
                        enemie.setY(enemie.getY()+5);// Déplace ennemi de 5 pixels vers le bas
                    }

                    temps++;
                })
        );
        // ajoute le key frame dans le gameLoop timeline
        gameLoop.getKeyFrames().add(keyFrame);
    }

}

























