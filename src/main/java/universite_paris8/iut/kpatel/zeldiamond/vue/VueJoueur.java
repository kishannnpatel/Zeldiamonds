package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// Classe représentant la vue du joueur dans le jeu
public class VueJoueur {

    // ImageView pour afficher l'image du joueur
    private ImageView imageView;

    // Pane pour contenir l'ImageView du joueur
    private Pane rec;

    // Identifiant du joueur
    private int id;

    // Pane principal dans lequel le joueur sera ajouté
    private Pane paneMap;

    // Constructeur de la classe VueJoueur
    public VueJoueur(int id, Pane paneMap) {
        this.paneMap = paneMap;
        this.id = id;
    }

    // Méthode pour créer la vue du joueur
    public void creeVue() {
        this.imageView = new ImageView();
        // Définition de l'image pour l'ImageView du joueur
        imageView.setImage(new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/joueur/boy_down_1.png"));
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        // Définition de l'ID de l'ImageView pour identifier ce joueur
        this.imageView.setId(String.valueOf(id));
        // Création d'un Pane pour contenir l'ImageView du joueur
        rec = new Pane();
        rec.getChildren().add(imageView); // Ajout de l'ImageView au Pane
        paneMap.getChildren().add(rec); // Ajout du Pane au paneMap

        // Affichage des coordonnées de l'image dans la console pour le débogage
        System.out.println("Coordonnées du joueur (x, y) : " + imageView.getX() + ", " + imageView.getY());
    }

    // Méthode pour récupérer l'ImageView du joueur
    public ImageView getImageView() {
        return imageView;
    }

    // Méthode pour cacher l'image du joueur en la rendant invisible
    public void hideImage() {
        imageView.setVisible(false);
    }

    // Méthode pour récupérer le Pane contenant l'ImageView du joueur
    public Pane getRec() {
        return rec;
    }
}
