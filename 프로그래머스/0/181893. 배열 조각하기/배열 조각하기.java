import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        // 쿼리마다 처리할 수 있도록 결과를 ArrayList로 담기
        for (int i = 0; i < query.length; i++) {
            int index = query[i];
            if (i % 2 == 0) {
                // 짝수 인덱스일 때 (뒤부분을 자른다)
                arr = Arrays.copyOfRange(arr, 0, index+1);
            } else {
                // 홀수 인덱스일 때 (앞부분을 자른다)
                arr = Arrays.copyOfRange(arr, index, arr.length);
            }
        }

        // 결과 배열로 반환
        return arr;  // 최종적으로 남은 arr 배열을 반환
    }
}
