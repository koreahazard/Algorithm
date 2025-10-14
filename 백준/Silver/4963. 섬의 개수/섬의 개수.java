import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    static int w;
    static int h;
    static int[][] matrix;
    static boolean[][] visited;
    static int islandCount;
    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
            int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
            int[] cur = queue.poll();
            for(int k = 0; k < dx.length; k++) {
               int x = cur[0] + dx[k];
               int y = cur[1] + dy[k];
               if(x>= 0 && x < h && y >= 0 && y < w && !visited[x][y] && matrix[x][y] == 1) {
                   queue.add(new int[] {x, y});
                   visited[x][y] = true;
               }
            }
            if(queue.isEmpty()) {
                islandCount++;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] s = br.readLine().split(" ");
            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);
            if(w == 0 && h == 0) break;
            matrix = new int[h][w];
            visited = new boolean[h][w];
            islandCount = 0;
            for (int i = 0; i < h; i++) {
                s = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    matrix[i][j] = Integer.parseInt(s[j]);
                }
            }
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(matrix[i][j] == 1 && !visited[i][j]) {
                        bfs(i,j);
                    }
                }
            }

            System.out.println(islandCount);
        }

    }
}




