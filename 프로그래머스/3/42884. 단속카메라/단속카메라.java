import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int last = Integer.MIN_VALUE;
        int count = 0;
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
        
        for (int[] route : routes) {
            if (last >= route[0] && last <= route[1]) continue;
            
            count++;
            last = route[1];
        }
        return count;
    }
}