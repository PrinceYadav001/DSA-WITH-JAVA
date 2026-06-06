class Solution {
    public void sortColors(int[] nums) {
        int curr=0;
        int i =1;
        while(i<nums.length & curr<nums.length){
            if(nums[curr]==0){
                curr++;
                i++;
            }else if(nums[i]==0){
                int temp = nums[curr];
                nums[curr]= nums[i];
                nums[i] = temp;
                curr++;
                i++;
            }else{
                i++;
            }
            
        }
        int j=curr+1;
        while(j<nums.length && curr<nums.length){
            if(nums[curr]==1){
                curr++;
                j++;
            }else if(nums[j]==1){
                int temp = nums[curr];
                nums[curr]= nums[j];
                nums[j] = temp;
                curr++;
                j++;
            }else{
                j++;
            }
            
        }
        
    }
}