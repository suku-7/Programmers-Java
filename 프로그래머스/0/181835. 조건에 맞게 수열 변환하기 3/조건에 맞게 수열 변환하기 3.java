import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (k %2 == 1) {
                list.add(num*k);
            } else {
                list.add(num+k);
            }
        }
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}