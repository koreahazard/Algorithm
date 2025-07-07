import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num + 1];
        dp[1] = 1;
        if(num > 1) {
            dp[2] = 2;
        }
        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%10007;
        }
        System.out.println(dp[num]);




    }
//    static int f (int num)
//    {
//        if(num == 1){
//            return 1;
//        }
//
//        if(num == 2) {
//            return 2;
//        }
//
//        if(num == 3) {
//            return 3;
//        }
//        else {
//            return f(num-1)+f(num-2);
//        }
//    }
}




