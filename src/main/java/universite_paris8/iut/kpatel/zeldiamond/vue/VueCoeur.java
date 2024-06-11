package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VueCoeur {
    private static final int TAILLE_COEUR = 35; // Taille de l'image du cœur
    private static final int MAX_COEUR = 4; // Nombre maximum de cœurs

    private Image imageCoeurFull;
    private Image imageCoeurHalf;
    private Image imageCoeurEmpty;
    private ImageView[] coeur;

    public VueCoeur(Pane pane) {
        try {
            imageCoeurFull = new Image(getClass().getResourceAsStream("/universite_paris8/iut/kpatel/zeldiamond/coeur/heart_full.png"));
            imageCoeurHalf = new Image(getClass().getResourceAsStream("/universite_paris8/iut/kpatel/zeldiamond/coeur/heart_half.png"));
            imageCoeurEmpty = new Image(getClass().getResourceAsStream("/universite_paris8/iut/kpatel/zeldiamond/coeur/heart_blank.png"));

            if (imageCoeurFull == null || imageCoeurHalf == null || imageCoeurEmpty == null) {
                throw new NullPointerException("One or more images not found");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        coeur = new ImageView[MAX_COEUR];

        for (int i = 0; i < MAX_COEUR; i++) {
            coeur[i] = new ImageView(imageCoeurEmpty); // Initialize with empty hearts
            coeur[i].setFitWidth(TAILLE_COEUR);
            coeur[i].setFitHeight(TAILLE_COEUR);
            coeur[i].setX(i * TAILLE_COEUR);
            coeur[i].setY(0);
            pane.getChildren().add(coeur[i]);
        }
    }

    public void miseAJourCoeur(int nivDeVie) {
        if (coeur == null) {
            System.err.println("Erreur: Le tableau hearts est nul.");
            return;
        }

        int fullHearts = nivDeVie / 20;
        int halfHeart = (nivDeVie % 20) / 10;

        for (int i = 0; i < MAX_COEUR; i++) {
            if (i < fullHearts) {
                coeur[i].setImage(imageCoeurFull);
            } else if (i == fullHearts && halfHeart > 0) {
                coeur[i].setImage(imageCoeurHalf);
            } else {
                coeur[i].setImage(imageCoeurEmpty);
            }
        }
    }

    public void afficherImageSelonVie(int nivDeVie) {
        if (nivDeVie == 100) {
            setAllCoeursImage(imageCoeurFull);
        } else if (nivDeVie == 50) {
            // Au lieu de mettre à jour tous les coeurs à moitié remplis, nous mettons à jour correctement les coeurs
            miseAJourCoeur(40); // 2 coeurs pleins et 2 vides (50 pv représente 2.5 coeurs mais on le traite comme 2 coeurs pleins)
        } else if (nivDeVie == 0) {
            setAllCoeursImage(imageCoeurEmpty);
        } else {
            miseAJourCoeur(nivDeVie); // Mettre à jour normalement pour d'autres valeurs de vie
        }
    }

    private void setAllCoeursImage(Image image) {
        for (int i = 0; i < MAX_COEUR; i++) {
            coeur[i].setImage(image);
        }
    }
}
