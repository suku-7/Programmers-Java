import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleteList = new HashSet<>();
        
        for (int i=0; i<delete_list.length; i++) {
            deleteList.add(delete_list[i]);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int num : arr) {
            if (!deleteList.contains(num)) {
                resultList.add(num);
            }
        }
        int[] answer = new int[resultList.size()];
        for (int i=0; i<resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}