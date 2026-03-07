class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s+s;
        int alt1 =0;
        int alt2 =0;

        int res = Integer.MAX_VALUE;
        int l =0;
        for(int i =0 ; i<str.length(); i++){
            char exp1 = (i%2==0) ? '0' :'1';
            char exp2 = (i%2==0) ? '1' :'0';


            if(str.charAt(i)!=exp1) alt1++;
            if(str.charAt(i)!=exp2) alt2++;


            if(i-l +1 >n){
                char left1 = (l%2==0) ? '0' : '1';
                char left2 = (l%2==0) ? '1' : '0';

                if(str.charAt(l)!= left1) alt1--;
                if(str.charAt(l)!= left2) alt2--;

                l++;
            }
            if(i-l+1==n){
                res = Math.min(res , Math.min(alt1 , alt2));
            }
        }
        return res;
    }
}