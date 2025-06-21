import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            Comparator.comparingInt(j -> j[1])
        );
        
        int index = 0;
        int count = 0;
        int time = 0;
        int total = 0;
        
        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                heap.add(jobs[index]);
                index++;
            }
            if (heap.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] job = heap.poll();
                time += job[1];
                total += time - job[0];
                count++;
            }
        }
        return total / jobs.length;
    }
}