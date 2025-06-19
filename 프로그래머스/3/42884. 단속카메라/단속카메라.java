import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
        int count = 0;
        int last = Integer.MIN_VALUE;
        
        for (int i=0; i<routes.length; i++) {
            if (last >= routes[i][0] && last <= routes[i][1]) continue;
            last = routes[i][1];
            count++;
        }
        return count;
    }
}