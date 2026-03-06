class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        if(n<=2 && s.charAt(0)=='1'){
            return true;
        }
        for(int i=0 ; i<n-1; i++){
            if(s.charAt(i)=='0' && s.charAt(i+1)=='1'){
                return false;
            }
        }
        return true;
    }
}