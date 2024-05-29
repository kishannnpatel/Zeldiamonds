package universite_paris8.iut.kpatel.zeldiamond.Algo;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static int[] findNextStep(int startX, int startY, int targetX, int targetY, int[][] map) {
        int width = map.length;
        int height = map[0].length;

        boolean[][] visited = new boolean[width][height];
        int[][] prevX = new int[width][height];
        int[][] prevY = new int[width][height];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == targetX && y == targetY) {
                return reconstructPath(startX, startY, targetX, targetY, prevX, prevY);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (nx >= 0 && ny >= 0 && nx < width && ny < height && !visited[nx][ny] && map[nx][ny] != 0) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    prevX[nx][ny] = x;
                    prevY[nx][ny] = y;
                }
            }
        }

        // No path found
        return new int[]{startX, startY};
    }

    private static int[] reconstructPath(int startX, int startY, int targetX, int targetY, int[][] prevX, int[][] prevY) {
        int x = targetX;
        int y = targetY;

        while (prevX[x][y] != startX || prevY[x][y] != startY) {
            int tmpX = prevX[x][y];
            int tmpY = prevY[x][y];
            x = tmpX;
            y = tmpY;
        }

        return new int[]{x, y};
    }
}

