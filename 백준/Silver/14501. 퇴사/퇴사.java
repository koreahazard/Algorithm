import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] T;
    static int[] P;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            T[i]=Integer.parseInt(str[0]);
            P[i]=Integer.parseInt(str[1]);
        }

        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {

            if (i + T[i] <= N) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }


        System.out.println(dp[N]);

    }
}