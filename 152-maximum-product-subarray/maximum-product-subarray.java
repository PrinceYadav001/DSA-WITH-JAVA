class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];


        for(int i =1 ; i<nums.length; i++){
           
           int  tempmax= Math.max(nums[i] ,Math.max(nums[i]*max , min*nums[i]));
            int tempmin = Math.min(nums[i] , Math.min(nums[i]*max , nums[i]*min ));

            max = tempmax;
            min = tempmin;

            ans = Math.max(ans , max);
        }
        
        return ans;
    }
}