import java.util.*;

class Solution {
    public int solution(String name) {
        int len = name.length();
        int answer = 0 ;
        
        for (int i=0; i<len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        int move = len - 1;
        
        for (int i=0; i<len; i++) {
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            int leftRight = i + len - next + Math.min(i, len - next);
            move = Math.min(move, leftRight);
        }
        answer += move;
        return answer;
    }
}