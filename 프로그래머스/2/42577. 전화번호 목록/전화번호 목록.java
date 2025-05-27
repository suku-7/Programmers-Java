import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for (String p : phone_book) {
            set.add(p);
        }
        for (String p : phone_book) {
            for (int i=1; i<p.length(); i++) {
                String prefix = p.substring(0, i);
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}