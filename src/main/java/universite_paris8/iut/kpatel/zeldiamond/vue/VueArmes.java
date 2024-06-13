package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes.Epee;

public class VueArmes {
    private Pane paneMap;
    private Epee epee;
    private ImageView imageView;

    public VueArmes(Pane paneMap, Epee epee) {
        this.epee = epee;
        this.paneMap = paneMap;
        armes();  // Appel de la méthode vueArmes lors de l'instanciation
    }

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

    public ImageView getImageView() {
        return imageView;
    }
}
