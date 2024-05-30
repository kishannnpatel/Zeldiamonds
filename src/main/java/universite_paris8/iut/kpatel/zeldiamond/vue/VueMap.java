package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class VueMap {
    private  int[][] map ;
    private TilePane  tpMap;

    public VueMap(int[][] map, TilePane tpMap){
        this.map=map;
        this.tpMap=tpMap;

    }

    public void spriteMap() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                Rectangle r = new Rectangle(35, 35);

                if (map[i][j] == 1) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/maisonP.png");
                    r.setFill(new ImagePattern(img));
                } else if (map[i][j] == 2) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/fontaine.png");
                    r.setFill(new ImagePattern(img));


                }else if(map[i][j] == 3) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/maisond.png");
                    r.setFill(new ImagePattern(img));
                } else {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/herbe.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                }
                this.tpMap.getChildren().add(r);// Ajout  rectangle au conteneur TPMap pour l'afficher.
            }
        }
    }
}
