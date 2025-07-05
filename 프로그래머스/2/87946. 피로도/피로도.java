import java.util.*;

class Solution {
    static boolean[] visited;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return max;
    }
    private void dfs(int depth, int k, int[][] dungeons) {
        max = Math.max(max, depth);
        for (int i=0; i<dungeons.length; i++) {
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if (!visited[i] && k >= need) {
                visited[i] = true;
                dfs(depth+1, k-cost, dungeons);
                visited[i] = false;
            }
        }
    }
}