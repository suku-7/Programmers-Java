import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            if (operation.startsWith("I ")) {
                int num = Integer.parseInt(operation.substring(2));
                minHeap.add(num);
                maxHeap.add(num);
            } else if (operation.equals("D -1") && !minHeap.isEmpty()) {
                int min = minHeap.poll();
                maxHeap.remove(min);
            } else if (operation.equals("D 1") && !maxHeap.isEmpty()) {
                int max = maxHeap.poll();
                minHeap.remove(max);
            }
        }
        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
            return new int[] {0, 0};
        }
        return new int[] {maxHeap.poll(), minHeap.poll()};
    }
}