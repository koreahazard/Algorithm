import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] visited;
    static char[][] backyard;
    static int row, column;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        row = Integer.parseInt(firstLine[0]);
        column = Integer.parseInt(firstLine[1]);

        visited = new boolean[row][column];
        backyard = new char[row][column];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < column; j++) {
                backyard[i][j] = line.charAt(j);
            }
        }

        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!visited[i][j] && backyard[i][j] != '#') {
                    int[] result = dfs(i, j);

                    if (result[1] >= result[0]) {
                        result[0] = 0;
                    } else {

                        result[1] = 0;
                    }
                    sheep += result[0];
                    wolf += result[1];
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static int[] dfs(int x, int y) {
        int[] animals = new int[2]; // [0]: 양, [1]: 늑대
        visited[x][y] = true;

        if (backyard[x][y] == 'o') {
            animals[0]++;
        } else if (backyard[x][y] == 'v') {
            animals[1]++;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < row && ny >= 0 && ny < column) {
                if (!visited[nx][ny] && backyard[nx][ny] != '#') {
                    int[] result = dfs(nx, ny);
                    animals[0] += result[0];
                    animals[1] += result[1];
                }
            }
        }

        return animals;
    }
}
