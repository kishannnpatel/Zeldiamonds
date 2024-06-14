package universite_paris8.iut.kpatel.zeldiamond.vue;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class VueJoueur {
    private ImageView imageView;
    private Pane rec;
    private int id;
    private Pane paneMap;


    public VueJoueur(int id, Pane paneMap ) {
        this.paneMap = paneMap;
        this.id = id;
    }


    public void creeVue() {
        this.imageView = new ImageView();
        // Définition de l'image pour l'ImageView
        imageView.setImage(new Image("file:src/main/resources/" +
                "universite_paris8/iut/kpatel/" +
                "zeldiamond/joueur/boy_down_1.png"));
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        // Définition de l'ID de l'ImageView pour identifier ce joueur
        this.imageView.setId(String.valueOf(id));
        // Création d'un Pane pour contenir l'ImageView
        rec = new Pane();
        rec.getChildren().add(imageView);// Ajout de l'ImageView au Pane
        paneMap.getChildren().add(rec);// Ajout du Pane au paneMap
        // Affichage des coordonnées de l'image dans la console pour le débogage
        System.out.println(imageView.getX() );
        System.out.println(imageView.getY() );


    }

    public ImageView getImageView() {
        return imageView;
    }

    public void hideImage() {
        imageView.setVisible(false);
    }

    public Pane getRec() {
        return rec;
    }
}
