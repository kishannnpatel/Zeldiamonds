package universite_paris8.iut.kpatel.zeldiamond.modele;

import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Ennemi extends Acteur {
    private static final int VITESSE = 1; // Vitesse de déplacement de l'ennemi
    private static final int DISTANCE_ATTAQUE = 10; // Distance à laquelle l'ennemi attaque le joueur

    public Ennemi(int pv) {
        super(pv);
    }

    public void suivreJoueur(Joueur joueur, boolean[][] map) {
        int joueurX = joueur.getTranslateX() / 20;
        int joueurY = joueur.getTranslateY() / 20;
        int ennemiX = getTranslateX() / 20;
        int ennemiY = getTranslateY() / 20;

        // Effectuer une recherche BFS
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] prevX = new int[map.length][map[0].length];
        int[][] prevY = new int[map.length][map[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ennemiX, ennemiY});
        visited[ennemiX][ennemiY] = true;
        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny] && map[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    prevX[nx][ny] = x;
                    prevY[nx][ny] = y;

                    if (nx == joueurX && ny == joueurY) {
                        found = true;
                        break;
                    }
                }
            }
        }

        if (found) {
            int px = joueurX;
            int py = joueurY;
            while (prevX[px][py] != ennemiX || prevY[px][py] != ennemiY) {
                int tmpX = prevX[px][py];
                int tmpY = prevY[px][py];
                px = tmpX;
                py = tmpY;
            }

            setTranslateX(px * 20);
            setTranslateY(py * 20);
        }
    }

    public void attaquerJoueur(Joueur joueur) {
        joueur.setPv(joueur.getPv() - 10); // Inflige 10 points de dégâts au joueur
        System.out.println("L'ennemi attaque le joueur ! Points de vie restants du joueur : " + joueur.getPv());
    }
}



