class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int x : nums) sum += x;

        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;

        int s1 = (sum + target) / 2;
        int n = nums.length;

        int[][] dp = new int[n + 1][s1 + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][s1];
    }
}
