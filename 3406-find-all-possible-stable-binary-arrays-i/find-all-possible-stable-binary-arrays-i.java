class Solution {
    int MOD = 1000000007;
    long[][][][] dp;
    boolean[][][][] visited;

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new long[zero + 1][one + 1][2][limit + 1];
        visited = new boolean[zero + 1][one + 1][2][limit + 1];
        
        long ans = 0;
        // Start by placing a 0 or 1 first
        if (zero > 0) ans += dfs(zero - 1, one, 0, 1, limit);
        if (one > 0)  ans += dfs(zero, one - 1, 1, 1, limit);
        return (int)(ans % MOD);
    }

    private long dfs(int z, int o, int last, int count, int limit) {
        if (z == 0 && o == 0) return 1;

        if (visited[z][o][last][count])
            return dp[z][o][last][count];

        visited[z][o][last][count] = true;
        long ans = 0;

        // place 0
        if (z > 0) {
            if (last == 0) {
                if (count < limit)
                    ans += dfs(z - 1, o, 0, count + 1, limit);
            } else {
                ans += dfs(z - 1, o, 0, 1, limit);
            }
        }

        // place 1
        if (o > 0) {
            if (last == 1) {
                if (count < limit)
                    ans += dfs(z, o - 1, 1, count + 1, limit);
            } else {
                ans += dfs(z, o - 1, 1, 1, limit);
            }
        }

        return dp[z][o][last][count] = ans % MOD;
    }
}