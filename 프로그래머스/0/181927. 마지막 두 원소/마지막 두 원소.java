import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int last = num_list[num_list.length - 1];
        int secondLast = num_list[num_list.length - 2];
        int a;

        if (last > secondLast) {
            a = last - secondLast;
        } else {
            a = last * 2;
        }

        int[] answer = Arrays.copyOf(num_list, num_list.length + 1);
        answer[num_list.length] = a;

        return answer;
    }
}