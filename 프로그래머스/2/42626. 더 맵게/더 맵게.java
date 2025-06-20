import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        
        for (int s : scoville) {
            heap.add(s);
        }
        
        while (heap.size() >= 2 && heap.peek() < K) {
            int first = heap.poll();
            int second = heap.poll();
            int mixed = first + (second * 2);
            heap.add(mixed);
            count++;
        }
        if (heap.peek() >= K) {
            return count;
        } else {
            return -1;
        }
    }
}