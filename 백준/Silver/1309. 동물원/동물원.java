import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 9901;

        // dp[i][0] = i번째 줄에 사자 없음
        // dp[i][1] = i번째 줄에 왼쪽에만 있음
        // dp[i][2] = i번째 줄에 오른쪽에만 있음
        int[][] dp = new int[N + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        // N번째 줄 상태 3개 다 합치면 총 경우의 수
        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;

        System.out.println(result);
    }
}
