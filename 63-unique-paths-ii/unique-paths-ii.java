class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr[0][0]==1 || arr[arr.length-1][arr[0].length-1]==1){
            return 0;
        }
        int dp[][] = new int[arr.length][arr[0].length];
        for(int i =0 ; i<arr.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return uniquePath(arr , 0 , 0 , dp);
        
        
    }
    public static int uniquePath(int arr[][] , int i ,  int j ,int dp[][] ){
        if(i==arr.length-1 && j==arr[0].length-1 ){
            return 1;
        }
        if(i>=arr.length || j>=arr[0].length || arr[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int a = uniquePath(arr , i+1 , j , dp);
        int b = uniquePath(arr , i , j+1 , dp); 

        return  dp[i][j]=a+b;
    }
}