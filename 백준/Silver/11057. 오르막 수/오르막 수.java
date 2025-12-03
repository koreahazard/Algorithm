import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 길이 N

        // dp[i][j] = 길이 i, 마지막 숫자 j인 오르막 수 보기 좋게 dp[0]말고 dp[1]부터 쓸라고 크기 N+1
        long[][] dp = new long[N+1][10];
        long MOD = 10007;

        // 길이 1 초기값
        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1; // 길이 1이면 0~9 모두 1개씩
        }

        // 길이 2이상부터
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD;
                }
            }
        }

        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        System.out.println(result);
    }
}
