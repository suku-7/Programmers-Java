import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        
        int prev = -1;
        
        for (int num : arr) {
            if (num != prev) {
                queue.add(num);
                prev = num;
            }
        }
        int[] answer = new int[queue.size()];
        int i =0;
        
        while (!queue.isEmpty()) {
            answer[i] = queue.poll();
            i++;
        }
        
        return answer;
    }
}