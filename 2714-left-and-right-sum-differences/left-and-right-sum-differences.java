class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int arr [] = new int[n];
        arr[n-1]=nums[n-1];
        for(int i = n-2 ; i>=0 ; i--){
            arr[i] = nums[i]+arr[i+1];
            System.out.print(arr[i]+" ");
        }
        for(int i =1 ; i<n ; i++){
            nums[i]=nums[i]+nums[i-1];
        }
        for(int i =0 ; i<n ; i++){
            nums[i] = Math.abs(arr[i] - nums[i]);
        }
        return nums;
    }
}