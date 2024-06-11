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
        // Définition de l'image pour l'ImageView
        imageView.setImage(new javafx.scene.image.Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/Armes/Epee.png"));
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        this.imageView.setId(String.valueOf(epee));
        // Ajout de l'ImageView au paneMap existant
        paneMap.getChildren().add(imageView);
        // Affichage des coordonnées de l'image dans la console pour le débogage
        System.out.println("Coordonnées de l'image: X=" + imageView.getX() + ", Y=" + imageView.getY());
        imageView.translateXProperty().bind(epee.translateXProperty());
        imageView.translateYProperty().bind(epee.translateYProperty());
    }
}
