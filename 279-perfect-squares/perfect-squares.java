// class Solution {
//      public int numSquares(int  n ) {
//         int dp[] = new int[n+1];
//         Arrays.fill(dp , -1);
//         return minSquares(n , dp);
//     }
//     public int minSquares(int n ,int dp[]) {
//         if(isPerfect(n)) return 1;
//         if(dp[n]!=-1) return dp[n];
//         int min = Integer.MAX_VALUE;
//         for(int i =1 ; i*i<n ;i++){
//             int count =  minSquares(i*i , dp)+minSquares(n-i*i , dp);
//             min= Math.min(min , count);
//         }
//         return dp[n]= min;
//     }
   
//     public boolean isPerfect(int n){
//         int sqrt = (int)(Math.sqrt(n));
//         return (sqrt*sqrt==n);
//     }
// } 

class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=i;
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }return dp[n];
    }
}