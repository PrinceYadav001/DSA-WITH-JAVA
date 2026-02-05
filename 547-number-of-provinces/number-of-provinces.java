class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {

            if (vis[i] != true) {
                count++;
                dfsutil(isConnected, i, vis);
            }
        }
        return count;

    }

    public static void dfsutil(int isConnected[][], int n, boolean vis[]) {
        vis[n] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[n][i] == 1 && !vis[i]) {
                dfsutil(isConnected, i, vis);
            }
        }

    }
}