import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0][0] = true;
        queue.add(new int[] {0, 0});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && maps[nx][ny]==1) {
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[x][y]+1;
                        queue.add(new int[]{nx, ny});
                        
                        if (nx == n-1 && ny == m-1) {
                            return maps[nx][ny];
                        }
                    }
                }
            }
        }
        return -1;
    }
}