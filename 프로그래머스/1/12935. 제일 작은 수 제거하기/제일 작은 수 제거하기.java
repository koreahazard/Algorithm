import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr) {
        int temp =arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        if(arr.length==1)
        {    
                return new int[]{-1};
        }
        for(int i = 0; i<arr.length;i++)
        {  
                if( temp > arr[i])
                    temp = arr[i];
                list.add(arr[i]);
        }
        list.remove(Integer.valueOf(temp));
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            answer[i] = list.get(i);
        }
        return answer;
        }
}