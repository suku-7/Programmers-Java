import java.util.*;

class Solution {
    static final int SIZE = 102;
    static boolean[][] visited = new boolean[SIZE][SIZE];
    static boolean[][] map = new boolean[SIZE][SIZE];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int i=x1; i<=x2; i++) {
                for (int j=y1; j<=y2; j++) {
                    map[i][j] = true;
                }
            }
        }
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int i=x1+1; i<x2; i++) {
                for (int j=y1+1; j<y2; j++) {
                    map[i][j] = false;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        visited[characterX * 2][characterY * 2] = true;
        queue.add(new int[]{characterX * 2, characterY * 2, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            if (itemX * 2 == x && itemY * 2 == y) {
                return dist/2;
            }
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < SIZE && ny < SIZE) {
                    if (!visited[nx][ny] && map[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, dist+1});
                    }
                }
            }
        }
        return 0;
    }
}