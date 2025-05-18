import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();

        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            String cmd = tokens[0];
            int num = Integer.parseInt(tokens[1]);

            if (cmd.equals("I")) {
                minPq.offer(num);
                maxPq.offer(num);
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            } else if (cmd.equals("D")) {
                if (countMap.isEmpty()) continue;

                PriorityQueue<Integer> targetPq = num == 1 ? maxPq : minPq;
                cleanQueue(targetPq, countMap);  // 유효하지 않은 값 제거

                if (!targetPq.isEmpty()) {
                    int removed = targetPq.poll();
                    countMap.put(removed, countMap.get(removed) - 1);
                    if (countMap.get(removed) == 0) {
                        countMap.remove(removed);
                    }
                }
            }
        }

        cleanQueue(minPq, countMap);
        cleanQueue(maxPq, countMap);

        if (countMap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxPq.peek(), minPq.peek()};
        }
    }

    private void cleanQueue(PriorityQueue<Integer> pq, Map<Integer, Integer> countMap) {
        while (!pq.isEmpty()) {
            int num = pq.peek();
            if (!countMap.containsKey(num)) {
                pq.poll(); // 유효하지 않으면 제거
            } else {
                break; // 유효한 값이면 중단
            }
        }
    }
}
