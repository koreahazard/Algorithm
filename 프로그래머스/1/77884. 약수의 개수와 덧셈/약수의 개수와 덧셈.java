class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i =left; i<=right;i++)
        {
            int count = 0;
            
            for(int j=1; j<=i;j++)
            {
                if(i % j == 0)
                    count++;
                if(j==i && count % 2 == 0)
                    answer +=i;
                if(j==i && count % 2 == 1)
                    answer += -i;
                    
            }
        }
        return answer;
    }
}