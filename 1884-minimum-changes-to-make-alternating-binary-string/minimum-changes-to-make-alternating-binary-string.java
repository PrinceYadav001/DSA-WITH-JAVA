class Solution {
    public int minOperations(String s) {
        int a = minHelper(s , '1');
        int b = minHelper(s , '0');
        return Math.min(a , b);
    }
    public static int minHelper(String s , char ch){
        int count =0;
        for(int i=0 ; i<s.length() ;i++ ){
            char exp;
            if(i%2==0){
                exp = ch;
            }else{
                if(ch=='0'){
                    exp = '1';
                }else{
                    exp ='0';
                }
            }
            if(exp!=s.charAt(i)){
                count++;
            }
        }
        return count;
    }
}