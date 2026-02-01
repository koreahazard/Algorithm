import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        arr = new int[N];
        List<Integer> list  = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.parseInt(str[i]);
        }
        for(int i=N;i>0;i--)
        {
            list.add(arr[i-1],i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }


    }
}