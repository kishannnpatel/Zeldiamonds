package universite_paris8.iut.kpatel.zeldiamond.modele;

import javafx.geometry.Rectangle2D;

// Classe représentant une tuile dans le jeu
public class Tuile {

    // Coordonnée de la ligne de la tuile dans la grille
    private int row;

    // Coordonnée de la colonne de la tuile dans la grille
    private int col;

    // Type de la tuile (0: vide, 1: obstacle, etc.)
    private int type;

    // Taille de la tuile (supposée carrée)
    private double size;

    // Constructeur de la classe Tuile
    public Tuile(int row, int col, int type, double size) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.size = size;
    }

    // Méthode pour obtenir le type de la tuile
    public int getType() {
        return type;
    }

    // Méthode pour obtenir les limites de la tuile sous forme de Rectangle2D
    public Rectangle2D getBounds() {
        double x = col * size;
        double y = row * size;
        return new Rectangle2D(x, y, size, size);
    }
}
