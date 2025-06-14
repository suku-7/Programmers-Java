import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // 초기 스코빌 지수들을 힙에 모두 넣는다.
        for (int s : scoville) {
            heap.add(s);
        }
        int count = 0;
        while (heap.size() >= 2 && heap.peek()<K) {
            int first = heap.poll(); // 가장 맵지 않은 음식
            int second = heap.poll(); // 두 번째로 맵지 않은 음식
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