import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // 비용 기준으로 간선 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        // 유니온 파인드를 위한 parent 배열
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int answer = 0;
        int count = 0;

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];

            // 싸이클이 생기지 않으면 연결
            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += c;
                count++;

                // n-1개의 간선만 필요함
                if (count == n - 1) break;
            }
        }

        return answer;
    }

    // 유니온 파인드 - find
    private int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]); // 경로 압축
    }

    // 유니온 파인드 - union
    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
}
