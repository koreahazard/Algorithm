class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        int length = String.valueOf(n).length();
        answer = new int[length];
        for(int i=0;i<length;i++)
        {
            answer[i]=(int)(n%10);
            n/=10;
            
        }
            
        return answer;
    }
}