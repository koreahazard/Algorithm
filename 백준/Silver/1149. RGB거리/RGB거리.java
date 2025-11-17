import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] matrix;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][3];
        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0;j<3;j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        dp = new int[N][3];
        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]) + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {

            if(min>dp[N-1][i]) {
                min = dp[N-1][i];
            }
        }
        System.out.println(min);
    }
}