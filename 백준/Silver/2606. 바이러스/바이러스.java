import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        String[] secondLine = br.readLine().split(" ");
        int edge = Integer.parseInt(secondLine[0]);
        List<LinkedList<Integer>> list = new LinkedList<>();
        boolean[] infected = new boolean[Integer.parseInt(firstLine[0])+1];
        for(int i = 1; i<= Integer.parseInt(firstLine[0])+1; i++){
            list.add(new LinkedList<>());
        }
        for(int i = 1; i <= edge; i++) {
            String[] Line = br.readLine().split(" ");

            list.get(Integer.parseInt(Line[0])).add(Integer.parseInt(Line[1]));
            list.get(Integer.parseInt(Line[1])).add(Integer.parseInt(Line[0]));
        }
        Integer sum = bfs(list, infected);
        System.out.println(sum);
//        System.out.println(Arrays.toString(infected));

    }
    static Integer bfs( List<LinkedList<Integer>> list,boolean[] infected) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        infected[1] = true;
        Integer value;
        Integer sum = 0;
        while(!queue.isEmpty()) {
            value = queue.poll();
            sum +=1;
            if(value != null)
            {

                for (Integer i : list.get(value)) {
                    if(!infected[i]) {
                        queue.add(i);
                        infected[i] = true;
                    }
                }
            }

        }
        return sum-1;
    }
}



