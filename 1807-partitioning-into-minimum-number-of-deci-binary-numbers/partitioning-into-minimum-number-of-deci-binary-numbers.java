class Solution {
    public int minPartitions(String n) {
        int a = n.length();
        int m = Integer.MIN_VALUE;
        for(int i =0 ; i<a ; i++){
            char ch = n.charAt(i);
            int b = ch - '0';
            m = Math.max(m , b);
        }
        return m;
    }
}