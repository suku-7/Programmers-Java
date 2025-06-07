import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 이동 방향: 상하좌우
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // 방문 및 거리 저장용
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 시작점
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크 및 갈 수 있는 곳인지, 방문했는지 확인
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        // 거리 누적: 이전 거리 + 1
                        maps[nx][ny] = maps[x][y] +1;
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        int answer = maps[n-1][m-1];
        return answer == 1 ? -1 : answer;
    }
}