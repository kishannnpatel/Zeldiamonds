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

                //herbe
                if (map[i][j] == 0) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/herbe.png");
                    r.setFill(new ImagePattern(img));
                }

                // maison face devant

                else if (map[i][j] == 1) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDevant/1.png");
                    r.setFill(new ImagePattern(img));
                } else if (map[i][j] == 2) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDevant/2.png");
                    r.setFill(new ImagePattern(img));
                }else if(map[i][j] == 3) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDevant/3.png");
                    r.setFill(new ImagePattern(img));
                } else if(map[i][j] == 4) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDevant/4.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 5) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDevant/5.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 6) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDevant/6.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 7) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDevant/7.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 8) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDevant/8.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 9) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDevant/9.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                }
                // maison face deriere

                else if (map[i][j] == 10) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDeriere/10.png");
                    r.setFill(new ImagePattern(img));
                } else if (map[i][j] == 11) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDeriere/11.png");
                    r.setFill(new ImagePattern(img));
                }else if(map[i][j] == 12) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDeriere/12.png");
                    r.setFill(new ImagePattern(img));
                } else if(map[i][j] == 13) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDeriere/13.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 14) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDeriere/14.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 15) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDeriere/15.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 16) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDeriere/16.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 17) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDeriere/17.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                } else if(map[i][j] == 18) {
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/MaisonDeriere/18.png");
                    r.setFill(new ImagePattern(img));//si dans map numero != de 1 et 2, alors color BlueViolet.
                }

                //Fontaine
                else if (map[i][j] == 19) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/Fontaine/19.png");
                    r.setFill(new ImagePattern(img));
                } else if (map[i][j] == 20) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/Fontaine/20.png");
                    r.setFill(new ImagePattern(img));
                } else if (map[i][j] == 21) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/Fontaine/21.png");
                    r.setFill(new ImagePattern(img));
                } else if (map[i][j] == 22) {
                    r.setId("mur");
                    Image img = new Image("file:src/main/resources/" +
                            "universite_paris8/iut/kpatel/" +
                            "zeldiamond/tilemap/Fontaine/22.png");
                    r.setFill(new ImagePattern(img));
                }



                this.tpMap.getChildren().add(r);// Ajout  rectangle au conteneur TPMap pour l'afficher.
            }
        }
    }
}
