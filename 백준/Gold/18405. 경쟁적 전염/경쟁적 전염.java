import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;


public class Main {
    static  int S; //몇 초 후
    static int N; //행
    static int K;
    static int X; //좌표
    static int Y; //좌표
    static int[][] matrix;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[2]>=S)
            {
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<N &&!visited[nx][ny]&& matrix[nx][ny]==0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny,cur[2]+1});
                    matrix[nx][ny] = matrix[cur[0]][cur[1]];
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        matrix = new int[N][N];
        visited = new boolean[N][N];
        queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        List<int[]> list = new ArrayList<>();
        str = br.readLine().split(" ");
                S = Integer.parseInt(str[0]);
                X = Integer.parseInt(str[1]);
                Y = Integer.parseInt(str[2]);
                X--;
                Y--;
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        if(matrix[i][j]!=0)
                        {
                            list.add(new int[] {i,j,matrix[i][j]});
                        }
                    }
                }
                list.sort(Comparator.comparingInt(a -> a[2]));
                for(int i = 0; i < list.size(); i++) {
                    queue.offer(new int[]{list.get(i)[0],list.get(i)[1] ,0});
                    visited[list.get(i)[0]][list.get(i)[1]] = true;

                }
                bfs();
        System.out.println(matrix[X][Y]);





    }

}