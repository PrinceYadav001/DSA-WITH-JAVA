// class Solution {
//     public int countSquares(int[][] arr) {
//         for(int i =1 ; i<arr.length ; i++){
//             for(int j =1 ; j<arr[0].length ; j++){
//                 if(arr[i][j]==0){
//                     continue;
//                 }
//                 if(i>0 && j>0){
//                     arr[i][j] += Math.min(arr[i-1][j],Math.min(arr[i][j-1] , arr[i-1][j-1]));
//                 }
//             }
//         }
//         int count =0;
//         for(int i =0 ; i<arr.length ; i++){
//             for(int j =0 ; j<arr[0].length ; j++){
//                 count+=arr[i][j];
//             }
//         }
//         return count ;
//     }
// }





class Solution {
    public int countSquares(int[][] arr) {
        for(int i =1 ; i<arr.length; i++){
            for(int j=1 ; j<arr[0].length ; j++){
                if(arr[i][j]==0){
                    continue;
                }
                if(i>0 && j>0){
                   
                }
                 arr[i][j] = Math.min(arr[i-1][j] , Math.min(arr[i-1][j-1] , arr[i][j-1]))+1;
            }
        }
        int sum=0;
        for(int i =0 ; i<arr.length; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                sum+=arr[i][j];
            }
        }
        return sum;
    }
}