import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // wires의 각 간선을 하나씩 끊어보며 시뮬레이션
        for (int i = 0; i < wires.length; i++) {
            // 그래프 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            // i번째 간선을 제외하고 그래프 구성
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // 끊을 간선
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            // 아무 노드에서나 시작해서 하나의 네트워크 크기 계산
            boolean[] visited = new boolean[n + 1];
            int count = bfs(1, graph, visited);

            // 두 네트워크 크기의 차이 계산
            int diff = Math.abs(n - count - count);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private int bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
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