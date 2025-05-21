import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 양방향 그래프 구성
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        // BFS를 위한 거리 배열 및 방문 배열
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[now]+1;
                    queue.offer(next);
                }
            }
        }
        int maxDist = 0;
        for (int d : distance) {
            maxDist = Math.max(maxDist, d);
        }
        int count = 0;
        for (int d : distance) {
            if (d == maxDist) count++;
        }
        return count;
    }
}