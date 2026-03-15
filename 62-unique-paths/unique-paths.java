// class Solution {
//     public int uniquePaths(int m, int n) {
//         int dp[][] = new int[m][n];
//         for(int i =0 ; i<dp.length; i++){
//             Arrays.fill(dp[i] , -1);
//         }
//         // return memoHelper(m-1,n-1 , dp);
//         return tabulationHelper(m, n);
//     }
//     public int memoHelper(int m , int n , int dp[][]){
//         if(n==0 && m==0){
//             return 1;
//         }
//         if(n<0 || m<0){
//             return 0;
//         }
//         if(dp[m][n] !=-1){
//             return dp[m][n];
//         }
//         int a = memoHelper(m-1 , n , dp);
//         int b = memoHelper(m,n-1, dp);
//         dp[m][n] = a+b;
//         return dp[m][n];
//     }
//     public int tabulationHelper(int m , int n){
//         int dp[][] = new int[m][n];
//         for(int i = 0; i < m; i++){
//             dp[i][0] = 1;
//         }
//         for(int j = 0; j < n; j++){
//             dp[0][j] = 1;
//         }
//         for(int i = 1; i < m; i++){
//             for(int j = 1; j < n; j++){
//                 dp[i][j] = dp[i-1][j] + dp[i][j-1];
//             }
//         }
//         return dp[m-1][n-1];  
//     }
// }




class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i =0 ; i<m ;i++){
            Arrays.fill(dp[i] , -1);
        }
        return path(m-1,n-1 , dp);
    }
    public static int path(int m , int n , int dp[][]){
        if(n==0 && m==0){
            return 1;
        }
       if(n<0||m<0){
        return 0;
       }
       if(dp[m][n]!=-1){
        return dp[m][n];
       }
       int a =  path(m-1 , n , dp);
       int b = path(m , n-1,dp);
       return dp[m][n]= a+b;
    }
}