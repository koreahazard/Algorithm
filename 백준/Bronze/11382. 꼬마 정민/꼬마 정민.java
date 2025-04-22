import java.util.Scanner;

class Solution
{
    public long solution(long a, long b,long c)
    {
        long sum=0;
        sum=a+b+c;
        return sum;
    }
}
public class Main {
    public static void main(String[] args) {
       long a,b,c;

       Scanner sc = new Scanner(System.in);
       a = sc.nextLong();
       b = sc.nextLong();
       c = sc.nextLong();

        Solution sol = new Solution();
        long result=sol.solution(a,b,c);
        System.out.println(result);
    }
}