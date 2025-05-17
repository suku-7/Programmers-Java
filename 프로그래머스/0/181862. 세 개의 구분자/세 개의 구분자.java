import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] parts = myStr.split("[abc]");
        
        List<String> result = new ArrayList<>();
        for (String part : parts) {
            if (!part.isEmpty()) {
                result.add(part);
            }
        }
        if (result.isEmpty()) {
            return new String[] {"EMPTY"};
        }
        return result.toArray(new String[result.size()]);
    }
}