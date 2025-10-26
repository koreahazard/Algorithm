import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int row;
    static int col;
    static int year;
    static int iceberg;
    static List<int[]> iceList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        row = Integer.parseInt(str[0]);
        col = Integer.parseInt(str[1]);
        matrix = new int[row][col];
        visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j < col; j++){
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        while(true){
            melting();
            iceberg = 0;
            for (int i = 0; i < row; i++) {
                Arrays.fill(visited[i], false);
            }
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(!visited[i][j] && matrix[i][j] != 0){
                        visited[i][j] = true;
                        iceberg++;
                        dfs(i, j);
                    }
                }
            }
            if(iceberg > 1){
                System.out.println(year);
                break;
            } else if (iceberg == 0) {
                System.out.println(0);
                break;
            }
        }

    }
    static void dfs(int x, int y)
    {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < row &&  ny >= 0 && ny < col && !visited[nx][ny] && matrix[nx][ny] != 0)  {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
    static void melting()
    {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] cnt =  new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < row && ny >= 0 && ny < col && matrix[nx][ny] == 0) {
                            cnt[i][j]++;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] -= cnt[i][j];
                if(matrix[i][j] < 0){
                    matrix[i][j] = 0;
                }
            }
        }
        year++;
    }

}