import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int votesNeeded = 0;
        while (arr[0] < arr[getMaXIndex(arr)] || getMaXIndex(arr) != 0) {
            arr[getMaXIndex(arr)]--;
            arr[0]++;
            votesNeeded++;
        }
        System.out.println(votesNeeded);
    }
    public static int getMaXIndex(int[] arr) {
        int maxIndex=0;
        for (int index = 1; index < arr.length; index++) {
            if (arr[maxIndex] <= arr[index])
                maxIndex = index;
        }
        return maxIndex;
    }
}
