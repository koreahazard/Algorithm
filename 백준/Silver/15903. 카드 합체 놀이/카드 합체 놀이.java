import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N];
        str = br.readLine().split(" ");
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i = 0; i<arr.length;i++)
        {
            queue.add(Long.parseLong(str[i]));
        }
        while(M>0)
        {
            Long temp1 = 0L;
            Long temp2 = 0L;
            temp1 = queue.poll();
            temp2 = queue.poll();
            queue.add(temp1+temp2);
            queue.add(temp1+temp2);
            M--;
        }
        Long answer = 0L;
        while(!queue.isEmpty())
        {
            answer += queue.poll();
        }
        System.out.println(answer);
    }
}