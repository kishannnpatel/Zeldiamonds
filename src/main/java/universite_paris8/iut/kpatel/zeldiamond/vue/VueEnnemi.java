package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// Classe représentant la vue d'un ennemi dans le jeu
public class VueEnnemi {

    // ImageView pour afficher l'image de l'ennemi
    private ImageView imageView;

    // Pane pour contenir l'ImageView de l'ennemi
    private Pane rec;

    // Identifiant de l'ennemi
    private int id;

    // Pane principal dans lequel l'ennemi sera ajouté
    private Pane paneMap;

    // Constructeur de la classe VueEnnemi
    public VueEnnemi(int id, Pane paneMap) {
        this.paneMap = paneMap;
        this.id = id;
        creeVueEnnemi(); // Appel de la méthode pour créer la vue de l'ennemi
    }

    // Méthode pour créer la vue de l'ennemi
    public void creeVueEnnemi() {
        this.imageView = new ImageView();
        // Définition de l'image pour l'ImageView
        imageView.setImage(new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/enemie/ennemi.png"));
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        // Définition de l'ID de l'ImageView pour identifier cet ennemi
        this.imageView.setId(String.valueOf(id));
        // Création d'un Pane pour contenir l'ImageView
        rec = new Pane();
        rec.getChildren().add(imageView); // Ajout de l'ImageView au Pane
        paneMap.getChildren().add(rec); // Ajout du Pane au paneMap

        // Affichage des coordonnées de l'image dans la console pour le débogage
        System.out.println("Coordonnées de l'ennemi (x, y) : " + imageView.getX() + ", " + imageView.getY());
    }

    // Méthode pour cacher l'ennemi en le rendant invisible
    public void hideEnnemi() {
        imageView.setVisible(false);
    }

    // Méthode pour récupérer l'ImageView de l'ennemi
    public ImageView getImg() {
        return imageView;
    }

    // Méthode pour récupérer le Pane contenant l'ImageView de l'ennemi
    public Pane getRec() {
        return rec;
    }
}
