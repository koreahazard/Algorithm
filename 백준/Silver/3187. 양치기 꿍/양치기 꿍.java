import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int row;
    static int col;
    static char[][] matrix;
    static boolean[][] visited;
    static int sheepCount;
    static int wolfCount;
    static void dfs(int i, int j) {
        int survivedSheep = 0;
        int survivedWolf = 0;
        int[] dx={-1,0,1,0};
        int[] dy={0,-1,0,1};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;
        int[] cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for(int k = 0; k < 4; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];
                if(x>=0 && x<row && y>0 && y<col && !visited[x][y]&&matrix[x][y]!='#') {
                    queue.add(new int[] {x, y});
                    visited[x][y]=true;
                    if(matrix[x][y]=='v') {
                        survivedWolf++;
                    }
                    if(matrix[x][y]=='k') {
                        survivedSheep++;
                    }
                }

            }
        }
        if(survivedSheep > survivedWolf) {
            survivedWolf=0;
        }
        else
        {
            survivedSheep=0;
        }
        sheepCount+=survivedSheep;
        wolfCount+=survivedWolf;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        row = Integer.parseInt(str[0]);
        col = Integer.parseInt(str[1]);
        matrix = new char[row][col];
        visited = new boolean[row][col];
        char[] ch;
        for (int i = 0; i < row; i++) {
            ch = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = ch[j];
            }
        }
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                dfs(i,j);
            }
        }
        System.out.println(sheepCount+" "+wolfCount);

    }
}