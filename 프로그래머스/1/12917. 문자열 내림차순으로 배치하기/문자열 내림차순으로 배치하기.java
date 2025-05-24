import java.util.Arrays;

class Solution {
    public String solution(String s) {
        
        char[] answer = s.toCharArray();

       
        Arrays.sort(answer);

       
        StringBuilder sb = new StringBuilder(new String(answer));
        sb.reverse();

        return sb.toString();
    }
}