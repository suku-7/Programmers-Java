import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i=1; i<=n; i++) {
            if (i % k ==0) {
                list.add(i);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}