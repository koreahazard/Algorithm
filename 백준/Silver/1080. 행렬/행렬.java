import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int[][] matrix1;
    static int[][] matrix2;
    static int count;
    static void change(int i, int j)
    {
        for(int n=i;n<i+3;n++)
        {
            for(int k=j; k<j+3;k++)
            {
                if(matrix1[n][k] == 1)
                {
                    matrix1[n][k] = 0;
                }
                else{
                    matrix1[n][k] = 1;
                }
            }
        }
        count++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        matrix1 = new int[N][M];
        matrix2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                matrix1[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                matrix2[i][j] = Integer.parseInt(str[j]);
            }
        }
        if (matrix1[0].length < 3 || matrix1.length < 3) {
            for(int i=0; i< matrix1.length;i++)
            {
                for(int j=0; j<matrix2[0].length;j++)
                {
                    if(matrix1[i][j]!=matrix2[i][j])
                    {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(0);
            return;
        }
        for(int i=0; i<N;i++)
        {
            for(int j=0; j<M;j++)
            {
                if(matrix1[i][j]!=matrix2[i][j])
                {
                    if(i+2<N && j+2<M) {

                        change(i,j);
                    }

                }
            }
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(matrix1[i][j]!=matrix2[i][j])
                {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);


    }
}