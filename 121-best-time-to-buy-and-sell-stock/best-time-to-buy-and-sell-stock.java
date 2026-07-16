class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int i=0; i<prices.length; i++){
            min = Math.min(min , prices[i]);
            max = Math.max(max , prices[i]-min); 
        }
        return max;
    }
}
// class Solution {
//     public int maxProfit(int[] prices) {
//         int max =0;
//         for(int i =0 ; i<prices.length; i++){
//             for(int j =i+1 ; j<prices.length ; j++){
//                 max = Math.max(max , prices[j]-prices[i]);
//             }
//         }
//         return max;
//     }
// }