import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    static int testCount;
    static char[][] matrix;
    static int row;
    static int col;
    static List<int[]> fireList;
    static int man = 1;
    static int fire = 0;
    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        for(int i=0;i<fireList.size();i++) {
            queue.add(new int[]{fireList.get(i)[0], fireList.get(i)[1],fire});
        }
        queue.add(new int[]{x, y, man, 0 });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[2] == man && (cur[0]==0 || cur[0] == row-1 || cur[1] == 0|| cur[1] == col-1))
            {
                System.out.println(cur[3]+1);
                return;
            }
            for(int i=0;i<4;i++)
            {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx>=0 && nx<row && ny>=0 && ny<col) {

                    if (cur[2] == 0) {
                        if (matrix[nx][ny] == '@' || matrix[nx][ny] == '.') {
                            matrix[nx][ny] = '*';
                            queue.add(new int[]{nx, ny, fire});
                        }
                    }
                    if (cur[2] == 1) {
                        if (matrix[nx][ny] == '.') {
                            matrix[nx][ny] = '@';
                            queue.add(new int[]{nx, ny, man, cur[3]+1});
                        }
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        testCount = parseInt(str);
        while(testCount>0)
        {
            String[] st = br.readLine().split(" ");
            row= parseInt(st[1]);
            col= parseInt(st[0]);
            matrix = new char[row][col];
            int[] start = null;
            fireList = new ArrayList<>();
            for(int i=0;i<row;i++) {
                char[] ch = br.readLine().toCharArray();
                for(int j=0;j<col;j++)
                {
                    matrix[i][j] = ch[j];
                    if(matrix[i][j]=='@')
                    {
                        start=new int[]{i,j};
                    }
                    if(matrix[i][j]=='*')
                    {
                        fireList.add(new int[]{i,j});
                    }
                }
            }
            bfs(start[0],start[1]);
            testCount--;
        }

    }
}