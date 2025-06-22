import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++) {
            queue.add(new int[] {i, priorities[i]});
        }
        int answer = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean highP = false;
            
            for (int[] q : queue) {
                if (q[1] > current[1]) {
                    highP = true;
                    break;
                }
            }
            if (highP) {
                queue.add(current);
            } else {
                answer++;
                
                if (current[0] == location) {
                    return answer;
                }
            }
        }
        return 0;
    }
}