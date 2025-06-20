import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int left = 0;
        int right = distance;
        int answer = 0;
        Arrays.sort(rocks);
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int removed = 0;
            int past = 0;
            
            for (int i=0; i<rocks.length; i++) {
                if (rocks[i] - past < mid) {
                    removed++;
                } else {
                    past = rocks[i];
                }
            }
            if (distance - past < mid) {
                removed++;
            }
            
            if (removed > n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}