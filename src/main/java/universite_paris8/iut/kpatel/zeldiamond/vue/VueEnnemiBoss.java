package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// Classe représentant la vue d'un boss ennemi dans le jeu
public class VueEnnemiBoss {

    // ImageView pour afficher l'image du boss ennemi
    private ImageView imageView;

    // Pane pour contenir l'ImageView du boss ennemi
    private Pane rec;

    // Identifiant du boss ennemi
    private int id;

    // Pane principal dans lequel le boss ennemi sera ajouté
    private Pane paneMap;

    // Constructeur de la classe VueEnnemiBoss
    public VueEnnemiBoss(int id, Pane paneMap) {
        this.paneMap = paneMap;
        this.id = id;
        creeVueEnnemiBoss(); // Appel de la méthode pour créer la vue du boss ennemi
    }

    // Méthode pour créer la vue du boss ennemi
    public void creeVueEnnemiBoss() {
        this.imageView = new ImageView();
        // Définition de l'image pour l'ImageView du boss ennemi
        imageView.setImage(new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/enemie/ennemiBoss.png"));
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        // Définition de l'ID de l'ImageView pour identifier ce boss ennemi
        this.imageView.setId(String.valueOf(id));
        // Création d'un Pane pour contenir l'ImageView du boss ennemi
        rec = new Pane();
        rec.getChildren().add(imageView); // Ajout de l'ImageView au Pane
        paneMap.getChildren().add(rec); // Ajout du Pane au paneMap

        // Affichage des coordonnées de l'image dans la console pour le débogage
        System.out.println("Coordonnées du boss ennemi (x, y) : " + imageView.getX() + ", " + imageView.getY());
    }

    // Méthode pour cacher le boss ennemi en le rendant invisible
    public void hideEnnemiBoss() {
        imageView.setVisible(false);
    }

    // Méthode pour récupérer l'ImageView du boss ennemi
    public ImageView getImg() {
        return imageView;
    }

    // Méthode pour récupérer le Pane contenant l'ImageView du boss ennemi
    public Pane getRec() {
        return rec;
    }
}
