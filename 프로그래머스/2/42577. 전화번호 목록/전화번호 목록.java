import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for (String num : phone_book) {
            set.add(num);
        }
        
        for (String num : phone_book) {
            for (int i=1; i<num.length(); i++) {
                String prefix = num.substring(0, i);
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}