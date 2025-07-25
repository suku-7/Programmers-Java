import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i=0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (remain + speeds[i]-1) / speeds[i];
            queue.add(day);
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int first = queue.poll();
            int count = 1;
            
            while (!queue.isEmpty() && queue.peek() <= first) {
                queue.poll();
                count++;
            }
            result.add(count);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}