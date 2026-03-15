// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int dp[][] = new int[m][n];
//         for(int i =0 ; i<dp.length ;i++){
//             Arrays.fill(dp[i] , -1);
//         }
//         return memoHelper(grid , 0 ,0 , dp);
//     }
//     public int memoHelper(int grid[][] , int i, int j , int dp[][]){
//          if(j>=grid[0].length || i>=grid.length){
//             return Integer.MAX_VALUE;
//         }
//         if(i==grid.length-1 && j==grid[0].length-1){
//             return grid[i][j];
//         }
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         int down =0;
//         int right =0;
//          down = memoHelper(grid , i+1 ,j , dp);
//          right =memoHelper(grid ,i, j+1 , dp);
//         dp[i][j] = grid[i][j] + Math.min(down, right);
//         return dp[i][j];
//     }
// }


class Solution {
    public int minPathSum(int[][] arr) {
       int n = arr.length;
       int m = arr[0].length;
       int dp[][] = new int[n][m];
       dp[0][0]=arr[0][0];
       for(int i =1 ; i<n ; i++){
        dp[i][0] = dp[i-1][0]+arr[i][0];
       }
       for(int i =1 ; i<m ; i++){
        dp[0][i] = dp[0][i-1]+arr[0][i];
       }
       for(int i =1 ; i<n ; i++){
        for(int j =1  ; j<m ; j++){
            dp[i][j] = arr[i][j]+Math.min(dp[i-1][j] , dp[i][j-1]);
        }
       }
       return dp[n-1][m-1];
    }
}