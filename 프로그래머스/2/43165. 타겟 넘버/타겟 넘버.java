import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return answer;
    }
    private void dfs(int depth, int sum, int target, int[] numbers) {
        if (numbers.length == depth) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(depth+1, sum+numbers[depth], target, numbers);
        dfs(depth+1, sum-numbers[depth], target, numbers);
    }
}