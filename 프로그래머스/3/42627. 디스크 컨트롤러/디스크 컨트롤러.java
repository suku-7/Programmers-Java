import java.util.*;

class Solution {
    private static class Job {
        public final int start;
        public final int duration;
        
        private Job(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }
    
    public int solution(int[][] rawJobs) {
        Job[] jobs = new Job[rawJobs.length];
        for (int i=0; i<jobs.length; i++) {
            jobs[i] = new Job(rawJobs[i][0], rawJobs[i][1]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));
        Queue<Job> queue = new LinkedList<>(Arrays.asList(jobs));
        PriorityQueue<Job> heap = new PriorityQueue<>(Comparator.comparingInt(job -> job.duration));
        
        int exec = 0;
        int time = 0;
        
        while (!queue.isEmpty() || !heap.isEmpty()) {
            while (!queue.isEmpty() && queue.peek().start <= time) {
                heap.add(queue.poll());
            }
            if (heap.isEmpty()) {
                time = queue.peek().start;
                continue;
            }
            Job job = heap.poll();
            exec += time + job.duration - job.start;
            time += job.duration;
        }
        return exec / jobs.length;
    }
}