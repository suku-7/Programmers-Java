import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        for (int i=0; i<wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            
            for (int j=0; j<=n; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j=0; j<wires.length; j++) {
                if (i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            int count = bfs(graph, n, wires[i][0]);
            int diff = Math.abs(n - count - count);
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    public int bfs(List<List<Integer>> graph, int n , int start) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        int count = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}