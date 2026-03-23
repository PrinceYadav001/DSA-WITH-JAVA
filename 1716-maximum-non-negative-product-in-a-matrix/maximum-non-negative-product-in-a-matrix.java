class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long[][] max = new long[n][m];
        long[][] min = new long[n][m];

        max[0][0] = min[0][0] = grid[0][0];

        // First column
        for (int i = 1; i < n; i++) {
            max[i][0] = min[i][0] = max[i-1][0] * grid[i][0];
        }

        // First row
        for (int j = 1; j < m; j++) {
            max[0][j] = min[0][j] = max[0][j-1] * grid[0][j];
        }

        // Fill DP
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long a = grid[i][j] * max[i-1][j];
                long b = grid[i][j] * min[i-1][j];
                long c = grid[i][j] * max[i][j-1];
                long d = grid[i][j] * min[i][j-1];

                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long result = max[n-1][m-1];
        int mod = (int)(1e9 + 7);

        if (result < 0) return -1;
        return (int)(result % mod);
    }
}