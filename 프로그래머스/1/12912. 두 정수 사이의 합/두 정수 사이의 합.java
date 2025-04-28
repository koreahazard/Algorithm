class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if (b < a)
        {
            int temp = 0;
            temp = a;
            a=b;
            b=temp;
        }
        for(int i=a;i<=b; i++)
        {
            if(a==b)
            {
                answer +=a;
                break;
            }
            answer +=i;
        }
        return answer;
    }
}