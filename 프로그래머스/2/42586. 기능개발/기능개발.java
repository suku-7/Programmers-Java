import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (remain + speeds[i]-1) / speeds[i];
            queue.add(day);
        }
        List<Integer> answer = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int first = queue.poll();
            int count = 1;
            
            while (!queue.isEmpty() && queue.peek() <= first) {
                queue.poll();
                count++;
            }
            answer.add(count);
        }
        int[] result = new int[answer.size()];
        
        for (int i=0; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result; 
    }
}