import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] parts = myString.split("x", -1);
        
        List<String> filtered = new ArrayList<>();
        for (String s : parts) {
            if (!s.isEmpty()) {
                filtered.add(s);
            }
        }
        String[] result = new String[filtered.size()];
        filtered.toArray(result);
        Arrays.sort(result);
        return result;
    }
}