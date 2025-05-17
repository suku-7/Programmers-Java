import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> result = new ArrayList<>();
        
        for (String row : picture) {
            StringBuilder exRow = new StringBuilder();
            
            for (char c : row.toCharArray()) {
                for (int i=0; i<k; i++) {
                    exRow.append(c);
                }
            }
            for (int i=0; i<k; i++) {
                result.add(exRow.toString());
            }
        }
        return result.toArray(new String[0]);
    }
}