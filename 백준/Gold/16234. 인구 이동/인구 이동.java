import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int L;
    static int R;
    static int day = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<int[]> union;
    static int unionSum;

    static void dfs(int i, int j) {
        visited[i][j] = true;
        union.add(new int[]{i, j});
        unionSum += matrix[i][j];

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                int diff = Math.abs(matrix[nx][ny] - matrix[i][j]);
                if (diff >= L && diff <= R) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);
        R = Integer.parseInt(str[2]);

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        union = new ArrayList<>();
                        unionSum = 0;

                        dfs(i, j);

                        if (union.size() > 1) {
                            moved = true;
                            int avg = unionSum / union.size();
                            for (int[] pos : union) {
                                matrix[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }
            if (!moved) break;
            day++;
        }

        System.out.println(day);
    }
}
