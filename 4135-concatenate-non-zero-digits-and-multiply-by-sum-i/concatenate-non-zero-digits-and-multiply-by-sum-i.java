class Solution {
    public long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
        long a = n;
        long sum =0;
        StringBuilder str = new StringBuilder("");
        while(a>0){
            long b = a%10;
            a = a/10;
            if(b>0){
                sum +=b;
                str.append(b);
            }
        }
    
        String s =str.reverse().toString();
        long digit  = Long.parseLong(s);
        return digit*sum;
    }
}