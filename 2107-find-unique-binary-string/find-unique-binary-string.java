class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder str = new StringBuilder();
        for(int i =0 ; i<n ; i++){
            for(int j =0 ; j<n ; j++){
                if(i==j && nums[i].charAt(j)=='1'){
                    str.append('0');
                }else if(i==j && nums[i].charAt(j)=='0'){
                    str.append('1');
                }
            }
        }
        return str.toString();
    }
}