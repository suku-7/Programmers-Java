import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> hash = new HashSet<>();
        int[] result = new int[k];
        int count = 0;
        
        for (int num : arr) {
            if (!hash.contains(num)) {
                hash.add(num);
                result[count] = num;
                count++;
            }
            if (count==k) {
                break;
            }
        }
        while (count < k) {
            result[count] = -1;
            count++;
        }
        return result;
    }
}