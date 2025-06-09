import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int myVote = Integer.parseInt(st.nextToken());
        int voteNeeded = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < num-1; i++) {
            maxHeap.add(Integer.parseInt(br.readLine()));
        }
        int getMax;
        while(!maxHeap.isEmpty() && myVote <=maxHeap.peek()) {
            getMax = maxHeap.poll();
            maxHeap.add(getMax - 1);
            voteNeeded++;
            myVote++;
        }

        System.out.println(voteNeeded);


    }

}
