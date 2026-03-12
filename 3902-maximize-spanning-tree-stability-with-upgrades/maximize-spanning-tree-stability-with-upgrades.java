import java.util.*;

class Solution {

    int parent[];
    int rank[];

    public int maxStability(int n, int[][] edges, int k) {

        int low = 1;
        int high = 200000;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (can(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    boolean can(int n, int[][] edges, int k, int target) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int upgrades = 0;
        int used = 0;

        // must edges
        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if (must == 1) {

                if (s < target)
                    return false;

                if (union(u, v))
                    return false;

                used++;
            }
        }

        // optional edges without upgrade
        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if (must == 0 && s >= target) {

                if (find(u) != find(v)) {
                    union(u, v);
                    used++;
                }

                if (used == n - 1)
                    return true;
            }
        }

        // optional edges with upgrade
        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if (must == 0 && s < target && s * 2 >= target && upgrades < k) {

                if (find(u) != find(v)) {
                    union(u, v);
                    upgrades++;
                    used++;
                }

                if (used == n - 1)
                    return true;
            }
        }

        return used == n - 1;
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return true;

        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }

        return false;
    }
}