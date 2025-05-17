import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        List<Integer> result = new ArrayList<>();

        if (n==1) {
            for (int i=0; i<=b; i++) {
                result.add(num_list[i]);
            }
        } else if (n==2) {
            for (int i=a; i<num_list.length; i++) {
                result.add(num_list[i]);
            }
        } else if (n==3) {
            for (int i=a; i<=b; i++) {
                result.add(num_list[i]);
            }
        } else if (n==4) {
            for (int i=a; i<=b; i+=c) {
                result.add(num_list[i]);
            }
        }
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}