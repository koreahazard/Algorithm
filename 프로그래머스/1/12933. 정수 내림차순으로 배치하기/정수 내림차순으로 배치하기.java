import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        // 숫자를 문자열로 변환
        String nString = String.valueOf(n);
        int length = nString.length();

        // 각 자릿수를 문자열 배열에 저장
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.valueOf(nString.charAt(i));
        }

        // 문자열 배열을 내림차순으로 정렬
        Arrays.sort(array, Collections.reverseOrder());

        // 정렬된 배열을 이어붙여서 하나의 문자열 만들기
        StringBuilder result = new StringBuilder();
        for (String num : array) {
            result.append(num);
        }

        // 이어붙인 문자열을 long 타입으로 변환
        long answer = Long.parseLong(result.toString());

        
        return answer;
    }
}