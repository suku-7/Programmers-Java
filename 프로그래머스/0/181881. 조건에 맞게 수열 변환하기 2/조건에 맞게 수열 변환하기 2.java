import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int count = 0;
        boolean changed = true;
        
        while (changed) {
            changed = false;
            int[] next = new int[arr.length];
            
            for (int i=0; i<arr.length; i++) {
                if (arr[i]>=50 && arr[i]%2==0) {
                    next[i] = arr[i] / 2;
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    next[i] = arr[i] * 2 + 1;
                } else {
                    next[i] = arr[i];
                }
                if (next[i] != arr[i]) {
                    changed = true;
                }
            }
            if (changed) {
                arr = next;
                count++;
            }
        }
        return count;
    }
}