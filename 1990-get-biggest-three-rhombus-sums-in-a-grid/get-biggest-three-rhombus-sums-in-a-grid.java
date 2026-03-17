import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // size = 0 (single cell)
                set.add(grid[i][j]);

                int maxSize = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));

                for (int size = 1; size <= maxSize; size++) {

                    int sum = 0;

                    int x = i - size, y = j;

                    // top → right
                    for (int k = 0; k < size; k++) {
                        sum += grid[x + k][y + k];
                    }

                    // right → bottom
                    for (int k = 0; k < size; k++) {
                        sum += grid[i + k][j + size - k];
                    }

                    // bottom → left
                    for (int k = 0; k < size; k++) {
                        sum += grid[i + size - k][j - k];
                    }

                    // left → top
                    for (int k = 0; k < size; k++) {
                        sum += grid[i - k][j - size + k];
                    }

                    set.add(sum);
                }
            }
        }

        int k = Math.min(3, set.size());
        int[] ans = new int[k];

        int idx = 0;
        for (int val : set) {
            if (idx == k) break;
            ans[idx++] = val;
        }

        return ans;
    }
}