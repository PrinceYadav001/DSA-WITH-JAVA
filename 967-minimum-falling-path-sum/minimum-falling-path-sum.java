import java.util.*;

class Solution {
    int n;
    int[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        // Start from any column in first row
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, helper(0, j, matrix));
        }

        return ans;
    }

    public int helper(int i, int j, int[][] matrix) {

        // Out of bounds
        if (j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Last row
        if (i == n - 1) {
            return matrix[i][j];
        }

        // Memoized
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int down = helper(i + 1, j, matrix);
        int leftDiag = helper(i + 1, j - 1, matrix);
        int rightDiag = helper(i + 1, j + 1, matrix);

        dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
        return dp[i][j];
    }
}
