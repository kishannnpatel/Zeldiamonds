package universite_paris8.iut.kpatel.zeldiamond.vue;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class VueJoueur {
    private ImageView img;
    private Pane rec;
    private int id;
    private Pane paneMap;


    public VueJoueur(int id, Pane paneMap ) {
        this.paneMap = paneMap;
        this.id = id;
    }


    public void creeVue() {
        this.img = new ImageView();
        // Définition de l'image pour l'ImageView
        img.setImage(new Image("file:src/main/resources/" +
                "universite_paris8/iut/kpatel/" +
                "zeldiamond/joueur/boy_down_1.png"));
        img.setFitHeight(35);
        img.setFitWidth(35);
        // Définition de l'ID de l'ImageView pour identifier ce joueur
        this.img.setId(String.valueOf(id));
        // Création d'un Pane pour contenir l'ImageView
        rec = new Pane();
        rec.getChildren().add(img);// Ajout de l'ImageView au Pane
        paneMap.getChildren().add(rec);// Ajout du Pane au paneMap
        // Affichage des coordonnées de l'image dans la console pour le débogage
        System.out.println(img.getX() );
        System.out.println(img.getY() );


    }


    public ImageView getImg() {
        return img;
    }


    public Pane getRec() {
        return rec;
    }

}
