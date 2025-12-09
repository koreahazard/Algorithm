import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 읽기
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int S = Integer.parseInt(first[1]);
        int M = Integer.parseInt(first[2]);

        // 볼륨 변화 배열
        int[] V = new int[N + 1];
        String[] second = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(second[i - 1]);
        }

        // dp[i][v] = i번째 곡까지 했을 때 볼륨 v 가능 여부
        boolean[][] dp = new boolean[N + 1][M + 1];

        dp[0][S] = true;

        for (int i = 1; i <= N; i++) {
            for (int v = 0; v <= M; v++) {
                if (!dp[i - 1][v]) continue;

                if (v + V[i] <= M) {
                    dp[i][v + V[i]] = true;
                }
                if (v - V[i] >= 0) {
                    dp[i][v - V[i]] = true;
                }
            }
        }

        int answer = -1;
        for (int v = M; v >= 0; v--) {
            if (dp[N][v]) {
                answer = v;
                break;
            }
        }

        System.out.println(answer);
    }
}
