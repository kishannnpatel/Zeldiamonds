package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

// Classe représentant la vue de la carte (map) dans le jeu
public class VueMap {

    // Tableau représentant la carte avec les indices des tuiles
    private int[][] map;

    // TilePane pour contenir les tuiles de la carte
    private TilePane tpMap;

    // Constructeur de la classe VueMap
    public VueMap(int[][] map, TilePane tpMap) {
        this.map = map;
        this.tpMap = tpMap;
    }

    // Méthode pour générer visuellement la carte (les tuiles)
    public void spriteMap() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                Rectangle r = new Rectangle(35, 35); // Création d'un rectangle pour représenter une tuile

                // Différents types de tuiles avec leurs images correspondantes
                switch (map[i][j]) {
                    case 0:
                        r.setId("mur");
                        Image imgHerbe = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/herbe.png");
                        r.setFill(new ImagePattern(imgHerbe));
                        break;
                    case 1:
                        r.setId("mur");
                        Image imgMaisonDevant1 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDevant/1.png");
                        r.setFill(new ImagePattern(imgMaisonDevant1));
                        break;
                    case 2:
                        r.setId("mur");
                        Image imgMaisonDevant2 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDevant/2.png");
                        r.setFill(new ImagePattern(imgMaisonDevant2));
                        break;
                    case 3:
                        r.setId("mur");
                        Image imgMaisonDevant3 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDevant/3.png");
                        r.setFill(new ImagePattern(imgMaisonDevant3));
                        break;
                    case 4:
                        Image imgMaisonDevant4 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDevant/4.png");
                        r.setFill(new ImagePattern(imgMaisonDevant4));
                        break;
                    case 5:
                        Image imgMaisonDevant5 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDevant/5.png");
                        r.setFill(new ImagePattern(imgMaisonDevant5));
                        break;
                    case 6:
                        Image imgMaisonDevant6 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDevant/6.png");
                        r.setFill(new ImagePattern(imgMaisonDevant6));
                        break;
                    case 7:
                        Image imgMaisonDevant7 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDevant/7.png");
                        r.setFill(new ImagePattern(imgMaisonDevant7));
                        break;
                    case 8:
                        Image imgMaisonDevant8 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDevant/8.png");
                        r.setFill(new ImagePattern(imgMaisonDevant8));
                        break;
                    case 9:
                        Image imgMaisonDevant9 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDevant/9.png");
                        r.setFill(new ImagePattern(imgMaisonDevant9));
                        break;
                    case 10:
                        r.setId("mur");
                        Image imgMaisonDeriere10 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDeriere/10.png");
                        r.setFill(new ImagePattern(imgMaisonDeriere10));
                        break;
                    case 11:
                        r.setId("mur");
                        Image imgMaisonDeriere11 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDeriere/11.png");
                        r.setFill(new ImagePattern(imgMaisonDeriere11));
                        break;
                    case 12:
                        r.setId("mur");
                        Image imgMaisonDeriere12 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDeriere/12.png");
                        r.setFill(new ImagePattern(imgMaisonDeriere12));
                        break;
                    case 13:
                        Image imgMaisonDeriere13 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDeriere/13.png");
                        r.setFill(new ImagePattern(imgMaisonDeriere13));
                        break;
                    case 14:
                        Image imgMaisonDeriere14 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDeriere/14.png");
                        r.setFill(new ImagePattern(imgMaisonDeriere14));
                        break;
                    case 15:
                        Image imgMaisonDeriere15 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDeriere/15.png");
                        r.setFill(new ImagePattern(imgMaisonDeriere15));
                        break;
                    case 16:
                        Image imgMaisonDeriere16 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDeriere/16.png");
                        r.setFill(new ImagePattern(imgMaisonDeriere16));
                        break;
                    case 17:
                        Image imgMaisonDeriere17 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDeriere/17.png");
                        r.setFill(new ImagePattern(imgMaisonDeriere17));
                        break;
                    case 18:
                        Image imgMaisonDeriere18 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/MaisonDeriere/18.png");
                        r.setFill(new ImagePattern(imgMaisonDeriere18));
                        break;
                    case 19:
                        r.setId("mur");
                        Image imgFontaine19 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/Fontaine/19.png");
                        r.setFill(new ImagePattern(imgFontaine19));
                        break;
                    case 20:
                        r.setId("mur");
                        Image imgFontaine20 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/Fontaine/20.png");
                        r.setFill(new ImagePattern(imgFontaine20));
                        break;
                    case 21:
                        r.setId("mur");
                        Image imgFontaine21 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/Fontaine/21.png");
                        r.setFill(new ImagePattern(imgFontaine21));
                        break;
                    case 22:
                        r.setId("mur");
                        Image imgFontaine22 = new Image("file:src/main/resources/universite_paris8/iut/kpatel/zeldiamond/tilemap/Fontaine/22.png");
                        r.setFill(new ImagePattern(imgFontaine22));
                        break;
                    default:
                        r.setFill(javafx.scene.paint.Color.BLUEVIOLET); // Si aucun cas ne correspond, remplir en bleu violet
                        break;
                }

                tpMap.getChildren().add(r); // Ajout du rectangle au TilePane pour l'afficher
            }
        }
    }
}
