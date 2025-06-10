class Solution {
    boolean[] visited;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    private void dfs(int depth, int k, int[][] dungeons) {
        answer = Math.max(answer, depth);
        
        for (int i=0; i<dungeons.length; i++) {
            int minRequired = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if (!visited[i] && k >= minRequired) {
                visited[i] = true;
                dfs(depth+1, k-cost, dungeons);
                visited[i] = false;
            }
        }
    }
}