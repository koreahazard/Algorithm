import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static class Testcase {
        int x;
        int y;
        int row;
        int col;
        int cabCount;
        int[][] matrix;
        boolean[][] visited;
        int wormCount;
        void bfs(ArrayList<Testcase> testcases,int i,int j, int k) {
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[] {j,k});
            testcases.get(i).visited[j][k]=true;
            while (!queue.isEmpty()) {
                int[] dx = { -1,1,0,0};
                int[] dy = {0,0,-1,1};
                int[] current = queue.poll();
                for(int a = 0; a < 4; a++) {
                    int cx = current[0] + dx[a];
                    int cy = current[1] + dy[a];
                    if(cx >= 0 && cx < row && cy >= 0 && cy < col && matrix[cx][cy]==1 && !visited[cx][cy]) {
                        queue.add(new int[] {cx,cy});
                        visited[cx][cy]=true;
                    }
                }
                if(queue.isEmpty())
                    wormCount++;
            }

        }


        public Testcase() {}
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCaseCount = Integer.parseInt(br.readLine());
        ArrayList<Testcase> testcases = new ArrayList<>();
        for(int i = 0; i < TestCaseCount; i++) {
             testcases.add(new Testcase());
        }
        for(int i = 0; i < TestCaseCount; i++) {
            String[] firstLine = br.readLine().split(" ");
            testcases.get(i).row = Integer.parseInt(firstLine[0]);
            testcases.get(i).col = Integer.parseInt(firstLine[1]);
            testcases.get(i).cabCount =  Integer.parseInt(firstLine[2]);

            testcases.get(i).matrix = new int[testcases.get(i).row][testcases.get(i).col];
            testcases.get(i).visited = new boolean[testcases.get(i).row][testcases.get(i).col];

            for(int j = 0; j < testcases.get(i).cabCount; j++) {
                String[] cabIndex = br.readLine().split(" ");
                int cabRow = Integer.parseInt(cabIndex[0]);
                int cabCol = Integer.parseInt(cabIndex[1]);
                testcases.get(i).matrix[cabRow][cabCol]=1;
            }
        }
        for(int i = 0; i < testcases.size(); i++) {
            for(int j = 0; j < testcases.get(i).row; j++) {
                for(int k = 0; k < testcases.get(i).col; k++) {
                    if(testcases.get(i).matrix[j][k]==1 && !testcases.get(i).visited[j][k]) {
                      testcases.get(i).bfs(testcases,i,j,k);
                    }
                }
            }

        }
        for(int i=0;i< testcases.size();i++) {
            System.out.println(testcases.get(i).wormCount);
        }
    }
}