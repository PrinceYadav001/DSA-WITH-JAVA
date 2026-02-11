import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {   // ✔️ only land
                    count++;
                    bfs(grid, i, j, vis);
                }
            }
        }
        return count;
    }

    public static void bfs(char[][] grid, int i, int j, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        vis[i][j] = true;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0];
            int y = front[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (!vis[nx][ny] && grid[nx][ny] == '1') {
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
