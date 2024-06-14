package universite_paris8.iut.kpatel.zeldiamond.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// Classe représentant la vue des cœurs (représentant la vie du personnage) dans le jeu
public class VueCoeur {

    // Taille de l'image du cœur
    private static final int TAILLE_COEUR = 35;

    // Nombre maximum de cœurs à afficher
    private static final int MAX_COEUR = 4;

    // Images représentant les différents états du cœur
    private Image imageCoeurFull;
    private Image imageCoeurHalf;
    private Image imageCoeurEmpty;

    // Tableau des ImageView représentant les cœurs affichés
    private ImageView[] coeur;

    // Constructeur de la classe VueCoeur
    public VueCoeur(Pane pane) {
        try {
            // Chargement des images de cœur à partir des ressources
            imageCoeurFull = new Image(getClass().getResourceAsStream("/universite_paris8/iut/kpatel/zeldiamond/coeur/heart_full.png"));
            imageCoeurHalf = new Image(getClass().getResourceAsStream("/universite_paris8/iut/kpatel/zeldiamond/coeur/heart_half.png"));
            imageCoeurEmpty = new Image(getClass().getResourceAsStream("/universite_paris8/iut/kpatel/zeldiamond/coeur/heart_blank.png"));

            // Vérification si toutes les images ont été chargées avec succès
            if (imageCoeurFull == null || imageCoeurHalf == null || imageCoeurEmpty == null) {
                throw new NullPointerException("Une ou plusieurs images n'ont pas été trouvées.");
            }
        } catch (Exception e) {
            // En cas d'erreur lors du chargement des images
            System.err.println("Erreur: " + e.getMessage());
            return;
        }

        // Initialisation du tableau des ImageView pour les cœurs
        coeur = new ImageView[MAX_COEUR];

        // Création des ImageView pour chaque cœur
        for (int i = 0; i < MAX_COEUR; i++) {
            coeur[i] = new ImageView(imageCoeurEmpty); // Initialise avec des cœurs vides
            coeur[i].setFitWidth(TAILLE_COEUR);
            coeur[i].setFitHeight(TAILLE_COEUR);
            coeur[i].setX(i * TAILLE_COEUR);
            coeur[i].setY(0);
            pane.getChildren().add(coeur[i]);
        }
    }

    // Méthode pour mettre à jour l'affichage des cœurs en fonction du niveau de vie
    public void miseAJourCoeur(int nivDeVie) {
        if (coeur == null) {
            System.err.println("Erreur: Le tableau coeur est nul.");
            return;
        }

        // Calcul du nombre de cœurs pleins et de cœurs à moitié pleins
        int fullHearts = nivDeVie / 20;
        int halfHeart = (nivDeVie % 20) / 10;

        // Mise à jour des ImageView en fonction du niveau de vie
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

    // Méthode pour afficher une image spécifique en fonction du niveau de vie
    public void afficherImageSelonVie(int nivDeVie) {
        if (nivDeVie == 100) {
            setAllCoeursImage(imageCoeurFull);
        } else if (nivDeVie == 50) {
            // Traitement spécial pour 50 points de vie (2 coeurs pleins et 2 vides)
            miseAJourCoeur(40); // 2 coeurs pleins et 2 vides
        } else if (nivDeVie == 0) {
            setAllCoeursImage(imageCoeurEmpty);
        } else {
            miseAJourCoeur(nivDeVie); // Mettre à jour normalement pour d'autres valeurs de vie
        }
    }

    // Méthode privée pour définir une image spécifique pour tous les cœurs
    private void setAllCoeursImage(Image image) {
        for (int i = 0; i < MAX_COEUR; i++) {
            coeur[i].setImage(image);
        }
    }
}
