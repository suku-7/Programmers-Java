import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> resultList = new ArrayList<>();
        
        for (String str : intStrs) {
            String substring = str.substring(s, s+l);
            int value = Integer.parseInt(substring);
            
            if(value > k) {
                resultList.add(value);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i=0; i<resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}