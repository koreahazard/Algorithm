import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int day;
    static int[] stockCost;
    static long maxProfit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
       while(T>0) {
           day = Integer.parseInt(br.readLine());
           stockCost = new int[day];
           String[] str = br.readLine().split("\\s+");
           for (int i = 0; i < day; i++) {
               stockCost[i] = Integer.parseInt(str[i]);
           }
           maxProfit = 0;
           int maxPrice = stockCost[stockCost.length-1];

           for (int i = stockCost.length-1; i >= 0; i--) {
               if(stockCost[i]>maxPrice)
               {
                   maxPrice = stockCost[i];
               }
               if(maxPrice>stockCost[i])
               {
                   maxProfit+=(maxPrice-stockCost[i]);
               }
           }
           T--;
           System.out.println(maxProfit);
       }



    }
}