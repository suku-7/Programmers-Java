import java.util.*;

class Solution {
    private boolean isValid(long t, int n, int[] times) {
        long c = 0;
        for (int time : times) {
            c += t / time;
        }
        return c >= n;
    }

    public long solution(int n, int[] times) {
        long start = 1;
        long end = (long) Arrays.stream(times).max().getAsInt()*n;
        
        while (end > start) {
            long t = (start + end)/2;
            if (isValid(t, n, times)) {
                end = t;
            } else {
                start = t+1;
            }
        }
        return start;
    }
}