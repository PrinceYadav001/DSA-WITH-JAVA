class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Refrence 
        String prefix = strs[0];

        // Compare with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // yha pai ham check kr rhe prefix hai ye nhi agra hai to while 0 hoke stop hoga nhi to prefix chota hoga aur agra 0 bhi nhi hua prefix chota ho gye to isempty sai null string return ho jye ga 
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
