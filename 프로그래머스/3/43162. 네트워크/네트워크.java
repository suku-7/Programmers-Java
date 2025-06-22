import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        
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
                visited[i] = true;
                dfs(computers, visited, i, n);
            }
        }
    }
}