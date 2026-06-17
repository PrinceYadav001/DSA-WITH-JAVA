class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        int curr =0;
        for(int i =0 ; i<nums.length ; i++){
            if(count==0){
                curr = nums[i];
                count++;
            }else if(curr==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return curr;
    }
}