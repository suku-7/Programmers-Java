import java.util.*;


class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i, n);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int[][] computers, boolean[] visited, int current, int n) {
        visited[current] = true;
        for (int i=0; i<n; i++) {
            if (!visited[i] && computers[current][i] == 1) {
                dfs(computers, visited, i, n);
            }
        }
    }
}