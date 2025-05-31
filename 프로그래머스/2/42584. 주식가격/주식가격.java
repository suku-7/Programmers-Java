import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int top = stack.pop();
                answer[top] = i-top;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            answer[top] = n-top-1;
        }
        return answer;
    }
}