import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int bridgeWeight = 0;
        int idx = 0;
        
        for (int i=0; i<bridge_length; i++) {
            queue.add(0);
        }
        while (queue.isEmpty() || idx<truck_weights.length) {
            time++;
            
            bridgeWeight -= queue.poll();
            
            if (bridgeWeight + truck_weights[idx] <= weight) {
                queue.add(truck_weights[idx]);
                bridgeWeight += truck_weights[idx];
                idx++;
            } else {
                queue.add(0);
            }
        }
        return time + bridge_length;
    }
}