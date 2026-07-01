class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int i =1;
    int j =0;
    for(int k =0 ; k<piles.length ; k++){
        j = Math.max(piles[k] , j);
    }
    int ans =1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(check(piles , h , mid)){
                ans=  mid;
                j =mid-1;
            }else{
                i= mid+1;
            }
        }
        return ans;
    }
    public static boolean check(int nums[] , int h , int k){
        long count =0;
        for(int i =0 ; i<nums.length ; i++){
            count += (nums[i]+k-1)/k;
        }
        return count<=h;
    }
}