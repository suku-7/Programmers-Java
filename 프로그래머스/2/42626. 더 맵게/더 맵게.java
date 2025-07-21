import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int s : scoville) {
            heap.add(s);
        }
        int count = 0;
        while (heap.size() >= 2 && heap.peek() < K) {
            int first = heap.poll();
            int second = heap.poll();
            int mixed = first + (second*2);
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