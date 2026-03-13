import java.util.*;

class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long low = 0, high = (long)1e18;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (can(mid, mountainHeight, workerTimes))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    boolean can(long time, int H, int[] w) {

        long total = 0;

        for (int t : w) {

            long val = (long)(2.0 * time / t);

            long x = (long)((Math.sqrt(1 + 4 * val) - 1) / 2);

            total += x;

            if (total >= H)
                return true;
        }

        return total >= H;
    }
}