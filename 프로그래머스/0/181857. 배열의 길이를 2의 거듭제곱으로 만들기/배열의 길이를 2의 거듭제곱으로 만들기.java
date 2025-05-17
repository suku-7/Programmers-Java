import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        int count = 1;
        
        while (count < n) {
            count *=2;
        }
        if (count==n) {
            return arr;
        }
        
        int[] answer = new int[count];
        for (int i=0; i<count; i++) {
            answer[i] = 0;
        }
        for (int i=0; i<n; i++) {
            answer[i] = arr[i];
        }
        return answer;
    }
}