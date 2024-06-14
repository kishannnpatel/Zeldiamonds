package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes.Diamant;

public class VueDiamant {
    private Diamant diamant;
    private ImageView imageView;

    public VueDiamant(Diamant diamant, Pane paneMap) {
        this.diamant = diamant;
        this.imageView = new ImageView(new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/Armes/New Piskel-1.png.png")); // Remplacez par le chemin de l'image du diamant
        paneMap.getChildren().add(this.imageView);
        this.imageView.setTranslateX(diamant.getTranslateX());
        this.imageView.setTranslateY(diamant.getTranslateY());
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Diamant getDiamant() {
        return diamant;
    }
}
