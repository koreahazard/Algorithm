class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = num_list;
        int temp = 0;
        for(int i=0;i<num_list.length/2;i++)
        {
            temp = answer[i];
            answer[i]=answer[num_list.length-i-1];
            answer[num_list.length-i-1]=temp;
        }
        return answer;
    }
}