import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int row;
    static int col;
    static int z;
    static int[][][] matrix;
    static boolean[][][] visited;
    static int[] dz = {0, 0, 0, 0, 1,-1};
    static int[] dx = {1,-1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1,-1, 0, 0};
    static Queue<int[]> queue = new ArrayDeque<>();
    static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur=queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nz=cur[0]+dz[i];
                int nx=cur[1]+dx[i];
                int ny=cur[2]+dy[i];
                if(nz>=0 && nz < z && nx>=0 && nx < row && ny>=0 && ny < col) {
                    if(matrix[nz][nx][ny]==0) {
                        matrix[nz][nx][ny]=matrix[cur[0]][cur[1]][cur[2]]+1;
                        queue.add(new int[]{nz,nx,ny});
                    }

                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        row = Integer.parseInt(str[1]);
        col = Integer.parseInt(str[0]);
        z = Integer.parseInt(str[2]);
        matrix = new int[z][row][col];
        for(int i = 0; i < z; i++){
            for(int j = 0; j < row; j++){
                str = br.readLine().split(" ");
                for(int k = 0; k < col; k++){
                    matrix[i][j][k] = Integer.parseInt(str[k]);

                    if(matrix[i][j][k] == 1){
                        queue.add(new int[]{i,j,k});
                    }

                }
            }
        }
        bfs();
        boolean hasUnripe = false;
        int maxDay = 0;
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (matrix[i][j][k] == 0) {
                        hasUnripe = true;
                    }
                    maxDay = Math.max(maxDay, matrix[i][j][k]);
                }
            }
        }
        if (hasUnripe) {
            System.out.println(-1);
        } else {
            System.out.println(maxDay - 1);
        }




    }
}