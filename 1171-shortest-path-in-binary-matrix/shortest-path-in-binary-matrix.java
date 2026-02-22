import java.util.*;

class Solution {
    static class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] != 0 || grid[m-1][n-1] != 0) return -1;

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        grid[0][0] = 1;

        int dist = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair cur = q.poll();

                if (cur.i == m - 1 && cur.j == n - 1) {
                    return dist;
                }

                for (int k = 0; k < 8; k++) {
                    int ni = cur.i + dx[k];
                    int nj = cur.j + dy[k];

                    if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 0) {
                        grid[ni][nj] = 1;
                        q.add(new Pair(ni, nj));
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}