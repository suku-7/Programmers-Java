import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;        // 세로 길이
        int m = maps[0].length;     // 가로 길이

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[n][m]; // 방문 체크
        Queue<int[]> queue = new LinkedList<>(); // BFS용 큐

        // 시작 위치 (0,0) 설정
        visited[0][0] = true;
        queue.add(new int[]{0, 0});

        // BFS 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll();  // 현재 위치 꺼냄
            int x = current[0];
            int y = current[1];

            // 현재 위치에서 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];  // 다음 위치 x
                int ny = y + dy[i];  // 다음 위치 y

                // 범위 안이고, 길이 있고, 방문 안 한 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1 ) {
                        maps[nx][ny] = maps[x][y] + 1; // 이전 칸 + 1 (거리 누적)
                        visited[nx][ny] = true;        // 방문 표시
                        queue.add(new int[]{nx, ny}); // 큐에 넣기 (다음 탐색용)

                        // 도착점에 도착했으면 바로 거리 반환하며 종료
                        if (nx == n - 1 && ny == m - 1) {
                            return maps[nx][ny];
                        }
                    }
                }
            }
        }
        return -1; // 도착 못했으면 여전히 1 (초기값) → 실패
    }
}
