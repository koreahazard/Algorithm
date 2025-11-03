import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] matrix;
    static boolean[][] blindnessVisited;
    static int blindnessCount;
    static int normalCount;
    static boolean[][] normalVisited;
    static void dfs(int x, int y,boolean blind)
    {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N)
            {
                if(!blind && !normalVisited[nx][ny]&&(matrix[nx][ny]==matrix[x][y])) {
                    normalVisited[nx][ny] = true;
                    dfs(nx, ny,false);
                }
                if(blind && !blindnessVisited[nx][ny] &&((matrix[nx][ny] == matrix[x][y])
                        ||(matrix[x][y] == 'R' && matrix[nx][ny] == 'G')
                        ||(matrix[x][y] == 'G' && matrix[nx][ny] == 'R')))
                {
                    blindnessVisited[nx][ny] = true;
                    dfs(nx, ny,true);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        matrix = new char[N][N];
        blindnessVisited = new boolean[N][N];
        normalVisited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                matrix[i][j] = ch[j];
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!blindnessVisited[i][j]) {
                    dfs(i, j,true);
                    blindnessCount++;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!normalVisited[i][j]) {
                    dfs(i, j,false);
                    normalCount++;
                }
            }
        }
        System.out.println(normalCount+" "+blindnessCount);





    }
}