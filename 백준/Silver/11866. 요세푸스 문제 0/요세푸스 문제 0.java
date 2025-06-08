import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=a;i++)
        {
          queue.add(i);
        }

        while(count<a)
        {
            for(int i=1;i<b;i++)
            {
                queue.add(queue.poll());
            }
            list.add(queue.poll());
            count++;
        }

        System.out.print("<");
        for(int i =0; i<list.size();i++)
        {
            if(list.size()==i+1)
            {

                System.out.print(list.get(i));
            }
            else
            System.out.print(list.get(i)+", ");

        }
        System.out.print(">");

    }
}