import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int r;
    static int c;
    static int d;
    static int[][] matrix;
    static void dfs(int r, int c, int d) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        if (matrix[r][c] == 0) {
            matrix[r][c] = 2;
            count++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;

            int nx = r + dx[d];
            int ny = c + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (matrix[nx][ny] == 0) {
                    dfs(nx, ny, d);
                    return;
                }
            }
        }
        int back = (d + 2) % 4;
        int bx = r + dx[back];
        int by = c + dy[back];

        if (bx >= 0 && bx < N && by >= 0 && by < M) {
            if (matrix[bx][by] != 1) {
                dfs(bx, by, d);
            }
        }

    }

    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        d = Integer.parseInt(str[2]);
        matrix = new int[N][M];
        for(int i=0;i<N;i++)
        {
            str = br.readLine().split(" ");
            for(int j=0;j<M;j++)
            {
                matrix[i][j]= Integer.parseInt(str[j]);
            }
        }
        dfs(r,c,d);
        System.out.println(count);


    }
    


}