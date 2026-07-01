class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int j =1;
        int i =0;
        for(int k =0 ; k<weights.length; k++){
            j +=weights[k];
            i = Math.max(weights[k] , i);
        }
        int ans = j;
        while(i<=j){
            int mid= i+(j-i)/2;
            if(check(weights , days ,mid)){
                ans = mid;
                j = mid -1;
            }else{
                i = mid+1;
            }
        }
        return ans;
    }
    public static boolean check(int nums[] , int h , int k){
        int days =1;
        int currc=0;
        for(int i =0 ; i<nums.length; i++){
            if(currc+nums[i]>k){
                days++;
                currc= nums[i];
            }else{
                currc +=nums[i];
            }
        }
        return days<=h;
    }
}