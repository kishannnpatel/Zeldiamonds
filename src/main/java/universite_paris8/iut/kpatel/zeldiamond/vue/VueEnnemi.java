package universite_paris8.iut.kpatel.zeldiamond.vue;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class VueEnnemi {
    private int[][] tab;
    private ImageView img1;
    private Pane rec1;
    private int id;
    private Pane paneMap;


    public VueEnnemi(int id, Pane paneMap) {
        this.paneMap = paneMap;
        this.tab=tab;
        this.id = id;
    }


    public void creeVue2() {
        this.img1 = new ImageView();
        // Définition de l'image pour l'ImageView
        img1.setImage(new Image("file:src/main/resources/" +
                "universite_paris8/iut/kpatel/" +
                "zeldiamond/enemie/ennemi_down_12.png"));
        img1.setFitHeight(70);
        img1.setFitWidth(70);
        // Définition de l'ID de l'ImageView pour identifier ce joueur
        this.img1.setId(String.valueOf(id));
        // Création d'un Pane pour contenir l'ImageView
        rec1 = new Pane();
        rec1.getChildren().add(img1);// Ajout de l'ImageView au Pane
        paneMap.getChildren().add(rec1);// Ajout du Pane au paneMap
        // Affichage des coordonnées de l'image dans la console pour le débogage
        System.out.println(img1.getX() );
        System.out.println(img1.getY() );

    }


    public ImageView getImg() {
        return img1;
    }


    public Pane getRec() {
        return rec1;
    }












}
