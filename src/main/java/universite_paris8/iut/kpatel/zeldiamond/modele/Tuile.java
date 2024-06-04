package universite_paris8.iut.kpatel.zeldiamond.modele;

import javafx.geometry.Rectangle2D;

public class Tuile {

    private int row;
    private int col;
    private int type; // Type of the tile (0: empty, 1: obstacle, etc.)
    private double size; // Size of the tile (assumed square)

    public Tuile(int row, int col, int type, double size) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public Rectangle2D getBounds() {
        double x = col * size;
        double y = row * size;
        return new Rectangle2D(x, y, size, size);
    }
}
