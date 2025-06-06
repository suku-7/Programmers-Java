import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int max = 0;
        int n = dungeons.length;
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(k, new boolean[n], 0));
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            max = Math.max(max, current.depth);
            
            for (int i=0; i<n; i++) {
                int minRequired = dungeons[i][0];
                int cost = dungeons[i][1];
                
                if (!current.visited[i] && current.k >= minRequired) {
                    boolean[] newVisited = Arrays.copyOf(current.visited, n);
                    newVisited[i] = true;
                    queue.add(new State(current.k - cost, newVisited, current.depth+1));
                }
            }
        }
        return max;
    }
    static class State {
        int k;
        boolean[] visited;
        int depth;
        
        public State(int k, boolean[] visited, int depth) {
            this.k = k;
            this.visited = visited;
            this.depth = depth;
        }
    }
}