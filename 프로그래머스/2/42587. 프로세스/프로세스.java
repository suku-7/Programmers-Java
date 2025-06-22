import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        
        for (int i=0; i<priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }
        
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
                
                if (location == current[0]) {
                    return answer;
                }
            }
        }
        return answer;
    }
}