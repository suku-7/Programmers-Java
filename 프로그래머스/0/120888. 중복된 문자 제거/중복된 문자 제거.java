import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> used = new HashSet<>();
        
        StringBuilder builder = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (used.contains(c)) continue;
            used.add(c);
            builder.append(c);
        }
        return builder.toString();
    }
}