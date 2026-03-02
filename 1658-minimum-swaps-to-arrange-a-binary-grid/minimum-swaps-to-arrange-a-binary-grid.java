class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int tz [] = new int[n];
        for(int i =0 ; i<n ; i++){
            int count=0;
            for(int j =n-1 ; j>=0 ; j--){
                if(grid[i][j]==0){
                    count++;
                }else{
                    break;
                }
            }
            tz[i]=count;
        }
        int swap = 0;
        for(int i =0 ; i<n ; i++){
            int r = n-i-1;
            int j =i;


            while(j<n && tz[j]<r){
                j++;
            }
            if(j==n){
                return -1;
            }

            while(j>i){
                int temp = tz[j];
                tz[j]=tz[j-1];
                tz[j-1] = temp;
                j--;
                swap++;
            }  
        }
        return swap;
    }
}