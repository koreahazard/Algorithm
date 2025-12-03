import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N+1];
        for(int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // 포도주가 3개 미만 일 때
        if (N == 1) {
            System.out.println(wine[1]);
            return;
        }
        if (N == 2) {
            System.out.println(wine[1] + wine[2]);
            return;
        }

        int[] dp = new int[N+1];

        //dp[i]는 i까지 포도주를 마실 때 최대로 마시는 방법 i번째를 안먹을 수도 있는 것
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];
        dp[3] = Math.max(dp[2],
                Math.max(wine[1] + wine[3], wine[2] + wine[3]));

        // 점화식 적용
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
        }

        System.out.println(dp[N]);
    }
}
