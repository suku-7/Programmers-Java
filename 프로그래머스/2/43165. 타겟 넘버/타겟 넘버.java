class Solution {
    int count =0;
    public int solution(int[] numbers, int target) {
        dfs(0, target, 0, numbers);
        return count;
    }
    private void dfs(int depth, int target, int sum, int[] numbers) {
        if (depth == numbers.length) {
            if (target == sum) {
                count++;
            }
            return;
        }

        dfs(depth+1, target, sum+numbers[depth], numbers);
        dfs(depth+1, target, sum-numbers[depth], numbers);
    }
}