import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int first = -1;
        int last = -1;
        
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 2) {
                if (first == -1) first =i;
                last = i;
            }
        }
        if (first == -1) return new int[]{-1};
        
        List<Integer> list = new ArrayList<>();
        for (int i=first; i<=last; i++) {
            list.add(arr[i]);
        }
        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}