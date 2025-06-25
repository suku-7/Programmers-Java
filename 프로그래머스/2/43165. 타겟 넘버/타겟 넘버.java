import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    private void dfs(int[] numbers, int target, int depth, int sum) {
        if (numbers.length == depth) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, depth+1, sum + numbers[depth]);
        dfs(numbers, target, depth+1, sum - numbers[depth]);
    }
}