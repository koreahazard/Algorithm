import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    static int row;
    static int col;
    static int[][] matrix;
    static boolean[][] visited;
    static boolean[][] outsideAir;
    static int[][] cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int hour;
    static boolean isAllMelted;
    static int lastCheese;
    static void melting()
    {
        cnt= new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {

                if(matrix[i][j]==1)
                {
                    isAllMelted =false;

                    for(int k=0;k<dx.length;k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];
                        if(nx>=0&&nx<row&&ny>=0&&ny<col&&matrix[nx][ny]==0&&outsideAir[nx][ny]){
                            cnt[i][j]=1;
                            break;
                        }
                    }
                }
            }
        }
    }
    static void dfsAir(int x, int y) {

                for(int k=0;k<dx.length;k++) {
                    int nx=x+dx[k];
                    int ny=y+dy[k];
                    if(nx>=0 && nx<row && ny >= 0 && ny<col && !outsideAir[nx][ny]&&matrix[nx][ny]==0) {
                        outsideAir[nx][ny]=true;
                        dfsAir(nx,ny);

                    }
                };


    }
    static int countCheese() {
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        row = Integer.parseInt(str[0]);
        col = Integer.parseInt(str[1]);
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        while (true) {
            outsideAir = new boolean[row][col];
            outsideAir[0][0] = true;
            dfsAir(0, 0);

            int cheeseNow = countCheese();
            if (cheeseNow == 0) {
                System.out.println(hour);
                System.out.println(lastCheese);
                break;
            }
            lastCheese = cheeseNow;
            melting();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] -= cnt[i][j];
                }
            }

            hour++;
        }
    }

}
