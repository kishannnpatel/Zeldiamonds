package universite_paris8.iut.kpatel.zeldiamond.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import universite_paris8.iut.kpatel.zeldiamond.modele.Joueur;

public class touche implements EventHandler<KeyEvent>{

    private Joueur joueur;

    public touche(Joueur joueur) {
        this.joueur = joueur;
    }

    @Override
    public void handle(KeyEvent event) {
        left(event);
        up(event);
        down(event);
        right(event);
    }

    /*------------------Touche-clavier-Haut(up=Z)-et-Bas(down=S)---------------*/

    private void up(KeyEvent event){
        if (event.getCode() == KeyCode.Z){
            int t = joueur.getY() -30;
            if(joueur.dansMap(joueur.getX(), t-1)){
               joueur.setY(t);
            }
        }
    }

    private void down(KeyEvent event){
        if (event.getCode() == KeyCode.S){
            int t = joueur.getY() + 30;
            if(joueur.dansMap(joueur.getX(), t)){
                joueur.setY(t);
            }
        }
    }

    /*------------------Touche-clavier-Gauche(left=Q)-et-Droite(right=D)---------------*/

    private void right(KeyEvent event){
        if (event.getCode() == KeyCode.D){
            int t = joueur.getX() + 30;
            if(joueur.dansMap(t, joueur.getY())){
                joueur.setX(t);
            }
        }
    }

    private void left(KeyEvent event){
        if (event.getCode() == KeyCode.Q){
            int t = joueur.getX() - 30;
            if(joueur.dansMap(t+1, joueur.getY())){
                joueur.setX(t);
            }
        }
    }





}
