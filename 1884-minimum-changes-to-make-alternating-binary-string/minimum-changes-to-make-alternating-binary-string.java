class Solution {
    public int minOperations(String s) {
        int startWith0 = helper(s, '0');
        int startWith1 = helper(s, '1');
        return Math.min(startWith0, startWith1);
    }

    public int helper(String s, char start) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected;

            if (i % 2 == 0) {
                expected = start;
            } else {
                expected = (start == '0') ? '1' : '0';
            }

            if (s.charAt(i) != expected) {
                count++;
            }
        }

        return count;
    }
}