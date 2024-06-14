package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes.Epee;

// Classe représentant la vue d'une arme dans le jeu
public class VueArmes {

    // Le conteneur dans lequel l'arme sera affichée
    private Pane paneMap;

    // L'arme associée à cette vue
    private Epee epee;

    // L'image view pour afficher l'arme
    private ImageView imageView;

    // Constructeur de la classe VueArmes
    public VueArmes(Pane paneMap, Epee epee) {
        this.epee = epee;
        this.paneMap = paneMap;
        armes();  // Appel de la méthode armes lors de l'instanciation
    }

    // Méthode pour initialiser et afficher l'image de l'arme
    public void armes() {
        this.imageView = new ImageView();
        imageView.setImage(new javafx.scene.image.Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/Armes/Epee.png"));
        imageView.setFitHeight(38);
        imageView.setFitWidth(38);
        this.imageView.setId(String.valueOf(epee));
        paneMap.getChildren().add(imageView);
        imageView.translateXProperty().bind(epee.translateXProperty());
        imageView.translateYProperty().bind(epee.translateYProperty());
    }

    // Méthode pour obtenir l'ImageView de l'arme
    public ImageView getImageView() {
        return imageView;
    }
}
