import java.util.*;

class Solution {
    static int SIZE = 102;
    static boolean[][] visited = new boolean[SIZE][SIZE];
    static boolean[][] maps = new boolean[SIZE][SIZE];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int i=x1; i<=x2; i++) {
                for (int j=y1; j<=y2; j++) {
                    maps[i][j] = true;
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
                    maps[i][j] = false;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            if (x == itemX * 2 && y == itemY * 2) {
                return dist / 2;
            }
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < SIZE && ny < SIZE) {
                    if (!visited[nx][ny] && maps[nx][ny] == true) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, dist+1});
                    }
                }
            }
        }
        return 0;
    }
}