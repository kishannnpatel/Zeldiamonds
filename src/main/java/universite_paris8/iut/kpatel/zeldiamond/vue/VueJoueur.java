package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VueJoueur {
        private int[][] tab;
        private ImageView img;
        private Pane rec;
        private int id;
        private Pane paneMap;

        public VueJoueur(int id, Pane paneMap, int[][] tab) {
            this.paneMap = paneMap;
            this.tab=tab;
            this.id = id;
        }

        public void creeVue() {
            this.img = new ImageView();
            img.setImage(new Image("file:src/main/resources/" +
                    "universite_paris8/iut/kpatel/" +
                    "zeldiamond/joueur/boy_down_1.png"));
            img.setFitHeight(35);
            img.setFitWidth(35);
            this.img.setId(String.valueOf(id));

            rec = new Pane();
            rec.getChildren().add(img);
            paneMap.getChildren().add(rec);

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
