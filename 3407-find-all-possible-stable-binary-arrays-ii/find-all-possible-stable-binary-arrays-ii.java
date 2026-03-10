class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        // dp[i][j][0] -> ends with 0
        // dp[i][j][1] -> ends with 1
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base cases: single blocks within the limit
        for (int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // To end with 0, we can add a 0 to a sequence ending in 1 OR another 0
                // Current = (dp[i-1][j][0] + dp[i-1][j][1])
                // Subtract sequences that would exceed the limit (more than 'limit' zeros)
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit) {
                    // If we exceed limit, subtract the configurations where we 
                    // just added 'limit + 1' zeros in a row.
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // Symmetric logic for ending with 1
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}