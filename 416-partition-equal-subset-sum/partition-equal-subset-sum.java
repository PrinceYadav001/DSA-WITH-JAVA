// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int i = 0 ; i<nums.length; i++){
//             sum+=nums[i];
//         }
//         if (sum % 2 != 0) {
//             return false;
//         }
//         sum = sum/2;
//         int i =0;
//         int dp[][] = new int[nums.length][sum + 1];
//         for(int j =0 ; j<dp.length; j++){
//             Arrays.fill(dp[j],-1);
//         }
//         int r =helper(nums, sum , i , dp);
//         if(r==1){
//             return true;
//         }else{
//             return false;
//         }
//     }
//     public int helper(int nums[], int sum , int i , int dp[][] ){
//         if(i == nums.length){
//             return 0;
//         }
//         if(sum == 0){
//             return 1;
//         }
//         if(dp[i][sum]!=-1){
//         return dp[i][sum];
//         }
//         int a = 0;
//         int res=nums[i];
//         if (sum-res>=0){
//              a = helper(nums, sum-res, i+1 , dp);
//         }
//         int b = helper(nums, sum ,i+1 , dp);
//         dp[i][sum] = (a == 1 || b == 1) ? 1 : 0;
//         return dp[i][sum];         
//     }  
// }


class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i =0 ; i<nums.length ;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum = sum/2;
        int n = nums.length;
        boolean dp[][] = new  boolean[n+1][sum+1];
            for(int i = 0 ; i<dp.length ; i++){
                dp[i][0] =true;
            }
            for(int i =1; i<n+1 ; i++){
                for(int j =1; j<sum+1 ; j++){
                    if(nums[i-1]<=j){
                        dp[i][j] =dp[i-1][j-nums[i-1]] || dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                
            }
                return  dp[n][sum];
    }
}