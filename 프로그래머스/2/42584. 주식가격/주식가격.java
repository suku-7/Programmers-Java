import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 결과를 담을 배열, 각 인덱스의 값은 해당 시점 이후 가격이 떨어지기까지 걸린 시간(초)
        int[] answer = new int[prices.length];
        
        // 가격이 떨어지지 않은 인덱스를 담을 스택
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // 스택이 비어있지 않고, 현재 가격이 스택에 저장된 인덱스의 가격보다 낮으면
            // (즉, 가격이 떨어진 상황)
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop(); // 가격이 떨어진 시점의 이전 인덱스를 꺼내고
                answer[index] = i - index; // 떨어질 때까지 걸린 시간(초) 계산
            }
            // 현재 인덱스를 스택에 저장 (아직 가격이 떨어지지 않은 상태)
            stack.push(i);
        }

        // 끝까지 가격이 떨어지지 않은 인덱스 처리
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1; // 끝까지 가격이 떨어지지 않으면 남은 시간
        }

        return answer;
    }
}
