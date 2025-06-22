import java.util.*;

class Solution {
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    private void dfs(int k, int[][] dungeons, int depth) {
        answer = Math.max(answer, depth);
        
        for (int i=0; i<dungeons.length; i++) {
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if (!visited[i] && need <= k) {
                visited[i] = true;
                dfs(k-cost, dungeons, depth+1);
                visited[i] = false;
            }
        }
    }
}