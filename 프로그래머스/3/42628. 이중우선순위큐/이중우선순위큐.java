import java.util.*;


class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);
            
            if (command.equals("I")) {
                minHeap.add(num);
                maxHeap.add(num);
                countMap.put(num, countMap.getOrDefault(num, 0)+1);
            } else if (command.equals("D")) {
                if (countMap.isEmpty()) continue;
                
                PriorityQueue<Integer> targetHeap = (num==1) ? maxHeap : minHeap;
                while (!targetHeap.isEmpty()) {
                    int val = targetHeap.poll();
                    if (countMap.containsKey(val)) {
                        if(countMap.get(val) == 1) {
                            countMap.remove(val);
                        } else {
                            countMap.put(val, countMap.get(val)-1);
                        }
                        break;
                    }
                }
            }
        }
        while (!maxHeap.isEmpty() && !countMap.containsKey(maxHeap.peek())) {
            maxHeap.poll();
        }
        while (!minHeap.isEmpty() && !countMap.containsKey(minHeap.peek())) {
            minHeap.poll();
        }
        if (countMap.isEmpty()) return new int[]{0, 0};
        return new int[] {maxHeap.peek(), minHeap.peek()};
    }
}