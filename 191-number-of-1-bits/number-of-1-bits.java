class Solution {
    public int hammingWeight(int n){
        int a=n;
        int count =0;
        while(a>0){
            if((a&1)==1){
                count++;
            }
            a = a>>1;
        }
        return count;
    }
}