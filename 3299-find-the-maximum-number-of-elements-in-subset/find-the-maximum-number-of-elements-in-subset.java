class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> map = new HashMap<>();

        // Keeping your way of inserting elements
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey((long) nums[i])) {
                map.put((long) nums[i], 1);
            } else {
                map.put((long) nums[i], map.get((long) nums[i]) + 1);
            }
        }

        int ans = 1;

        // Special case for 1
        if (map.containsKey(1L)) {
            int cnt = map.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        // Try every number as starting point
        for (long start : map.keySet()) {

            if (start == 1) continue;

            long curr = start;
            int count = 0;

            while (map.containsKey(curr) && map.get(curr) >= 2) {
                count++;
                curr = curr * curr;
            }

            if (map.containsKey(curr)) {
                ans = Math.max(ans, 2 * count + 1);
            } else {
                ans = Math.max(ans, 2 * count - 1);
            }
        }

        return ans;
    }
}