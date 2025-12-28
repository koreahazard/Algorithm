import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] matrix;
    static boolean[][] visited;
    static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{0,0,matrix[0][0]});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Integer[] arr = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = arr[0] + dx[i];
                int y = arr[1] + dy[i];
                if(x >= 0 && x < N && y >= 0 && y < M &&  !visited[x][y] && matrix[x][y] != 0){
                    visited[x][y] = true;
                    matrix[x][y] = arr[2] + 1;
                    queue.add(new Integer[]{x,y,matrix[x][y]});
                }
            }


        }
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        visited = new boolean[N][M];
        bfs();
        System.out.println(matrix[N-1][M-1]);


    }
}