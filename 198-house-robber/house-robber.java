// class Solution {
//     public int rob(int[] nums) {
//         int dp[] = new int[nums.length];
//         Arrays.fill(dp , -1);
//         return robHelper(nums , 0 , dp);
//     }
//     public int robHelper(int[] nums , int i , int dp[]) {
//         if(i>=nums.length){
//             return 0;
//         }
//         if(dp[i]!=-1){
//             return dp[i];
//         }
//         int take = nums[i]+robHelper(nums , i+2 , dp);
//         int skip =  robHelper(nums , i+1 , dp);
//         return dp[i]= Math.max(take , skip);
//     }   
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==2){
            return Math.max(nums[0] , nums[1]);
        }
        if(n==1){
            return nums[0];
        }
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] =Math.max(nums[0] , nums[1]);
        for(int i =2 ; i<n ; i++){
            dp[i]=Math.max(dp[i-1] , dp[i-2]+nums[i]);
        }
        return dp[n-1];
        // int ans = Integer.MIN_VALUE;
        // for(int i =0; i<n ; i++){
        //     ans = Math.max(ans , dp[i]);
        // }
        // return ans;
    }
}