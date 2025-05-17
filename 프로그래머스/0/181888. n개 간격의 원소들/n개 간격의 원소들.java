import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i=0; i<num_list.length; i+=n) {
            result.add(num_list[i]);
        }
        
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}