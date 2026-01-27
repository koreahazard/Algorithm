import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int T;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T>0)
        {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            String[] str = br.readLine().split(" ");
            for(int i=0; i<N;i++)
            {
                arr[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(arr);
            int[] temp = new int[N];
            int left =0;
            int right = N-1;
            for(int i =0; i<N; i++)
            {
                if(i%2==0)
                {
                    temp[left++]=arr[i];
                }
                else
                {
                    temp[right--] = arr[i];
                }
            }
            int answer = 0;
            for (int i = 0; i < N; i++) {
                int next = (i + 1) % N;
                answer = Math.max(answer, Math.abs(temp[i] - temp[next]));
            }
            System.out.println(answer);
            T--;
        }

    }
}