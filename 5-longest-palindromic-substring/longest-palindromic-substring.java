class Solution {
    int start =0;
     int maxlength=0;
    public String longestPalindrome(String s) {
        for(int i =0 ; i<s.length(); i++){
            expand(s , i , i);
            expand(s ,i , i+1);
        }
        return s.substring(start , start+maxlength);
    }  
    public void expand(String str , int left  ,int right){
        while(left>=0 && right<str.length() && str.charAt(left)== str.charAt(right)){
            left--;
            right++;
        }

        int len = right-left-1;
        if(len>maxlength){
            maxlength = len;
            start = left+1;
        }
    }
}