import java.util.*;

class Solution {
    int n;
    boolean[][] visited;

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        visited = new boolean[n][n];

        // Step 1: 빈칸 그룹(퍼즐 공간) 추출
        List<List<int[]>> blanks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && game_board[i][j] == 0) {
                    blanks.add(extractShape(game_board, i, j, 0));
                }
            }
        }

        // Step 2: 테이블 퍼즐 조각 추출
        visited = new boolean[n][n];
        List<List<int[]>> puzzles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && table[i][j] == 1) {
                    puzzles.add(extractShape(table, i, j, 1));
                }
            }
        }

        int answer = 0;
        boolean[] used = new boolean[puzzles.size()];

        // Step 3: 퍼즐 조각을 빈칸에 맞춰보기
        for (List<int[]> blank : blanks) {
            for (int i = 0; i < puzzles.size(); i++) {
                if (used[i]) continue;
                List<int[]> puzzle = puzzles.get(i);
                if (match(blank, puzzle)) {
                    answer += puzzle.size();
                    used[i] = true;
                    break;
                }
            }
        }

        return answer;
    }

    // 블록 또는 빈칸 그룹 추출
    private List<int[]> extractShape(int[][] board, int x, int y, int target) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> shape = new ArrayList<>();

        q.add(new int[]{x, y});
        visited[x][y] = true;

        int minX = x, minY = y;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            shape.add(cur);

            for (int[] d : dirs) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
                    !visited[nx][ny] && board[nx][ny] == target) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        // 좌상단 기준 정규화
        for (int[] p : shape) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        for (int[] p : shape) {
            p[0] -= minX;
            p[1] -= minY;
        }

        shape.sort((a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        return shape;
    }

    // 회전된 모든 경우 비교
    private boolean match(List<int[]> blank, List<int[]> puzzle) {
        for (int r = 0; r < 4; r++) {
            List<int[]> rotated = rotate(puzzle);
            if (blank.size() != rotated.size()) continue;

            boolean same = true;
            for (int i = 0; i < blank.size(); i++) {
                if (blank.get(i)[0] != rotated.get(i)[0] || blank.get(i)[1] != rotated.get(i)[1]) {
                    same = false;
                    break;
                }
            }
            if (same) return true;
            puzzle = rotated;
        }
        return false;
    }

    // 시계 방향 90도 회전 후 정규화
    private List<int[]> rotate(List<int[]> shape) {
        int maxX = 0, maxY = 0;
        for (int[] p : shape) {
            maxX = Math.max(maxX, p[0]);
            maxY = Math.max(maxY, p[1]);
        }

        List<int[]> result = new ArrayList<>();
        for (int[] p : shape) {
            result.add(new int[]{p[1], maxX - p[0]});
        }

        // 정규화
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] p : result) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        for (int[] p : result) {
            p[0] -= minX;
            p[1] -= minY;
        }

        result.sort((a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        return result;
    }
}
