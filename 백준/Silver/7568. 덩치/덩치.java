import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Information
{
    public int weight;
    public int height;
    public int rank;

    public Information(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int cnt = Integer.parseInt(st.nextToken());

        ArrayList<Information> list = new ArrayList<>();
        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Information(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }
        int i=0;
        for(i = 0; i < cnt; i++) {
            for(int j = 0; j < cnt; j++) {
                if(i != j) {
                    list.get(i).rank += checkBiggerMan(list.get(i), list.get(j));
                    
                }
            }

        }
        for(Information num: list) {
            System.out.print(num.rank+1+" ");
        }






    }
    public static int checkBiggerMan(Information information1, Information information2)
    {
        if((information1.weight < information2.weight) && (information1.height < information2.height)) {
            return 1;
        }
        else
            return 0;
    }
}