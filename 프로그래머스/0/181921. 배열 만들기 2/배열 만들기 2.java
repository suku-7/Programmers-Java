import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        for (int i=l; i<=r; i++) {
            if (isOnlyZeroAndFive(i)) {
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    private boolean isOnlyZeroAndFive(int num) {
        String str = String.valueOf(num);
        for (char ch : str.toCharArray()) {
            if (ch != '0' && ch != '5') {
                return false;
            }
        }
        return true;
    }
}