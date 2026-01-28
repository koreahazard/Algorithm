import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T;
    static int N;
    static int[][] arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-->0)
        {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            for(int i=0; i<N;i++)
            {
                String[] str = br.readLine().split(" ");
                    arr[i][0] =Integer.parseInt(str[0]);
                    arr[i][1] =Integer.parseInt(str[1]);

            }
            Arrays.sort(arr,(a,b)->a[0]-b[0]);
            int count =1;
            int bestInterviewer = arr[0][1];
            for(int i=1;i<N;i++)
            {
                if (arr[i][1] < bestInterviewer) {
                    count++;
                    bestInterviewer = arr[i][1];
                }
            }
            System.out.println(count);

        }

    }
}